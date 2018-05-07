package com.expedia.assingment.hotel.web.controller;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.ModelAndView;

import com.expedia.assingment.hotel.model.OfferSearchCriteria;
import com.expedia.assingment.hotel.model.json.Hotel;
import com.expedia.assingment.hotel.model.json.HotelOffers;
import com.expedia.assingment.hotel.service.HotelFinderService;

/**
 * Controller to handle Hotel search requests.
 * 
 * @author zaid
 *
 */
@Controller
@RequestMapping("/hotelOffer")
public class HotelOfferController {
	private Logger logger = Logger.getLogger(HotelOfferController.class);
	
	@Autowired
    private HotelFinderService hotelFinderService;
	
	@ModelAttribute
    public OfferSearchCriteria criteria() {
        return new OfferSearchCriteria();
    }

	/**
     * This method call the HotelFinderService based on the given {@link OfferSearchCriteria}. 
     * and pass the result to the JSP
     * 
     * @param criteria the criteria used for searching
     * @param model 
     * 
     * @see com.expedia.assingment.hotel.service.HotelFinderService#findOffers(OfferSearchCriteria)
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getOffers(@ModelAttribute("offerSearchCriteria") OfferSearchCriteria serchCriteria, 
			Map<String, Object> model) {
        String message = "";
        logger.info("processing new request");
        logger.info("inside getOffers");
        logger.trace("serchCriteria: " + serchCriteria);
        HotelOffers hotelOffers= hotelFinderService.findOffers(serchCriteria);
        logger.trace("result retrieved ");
        if (hotelOffers != null && hotelOffers.getOffers() != null
        		&& hotelOffers.getOffers().getHotels() != null
        		&& !hotelOffers.getOffers().getHotels().isEmpty()) {
        	model.put("hotelList", hotelOffers.getOffers().getHotels());
        	message = hotelOffers.getOffers().getHotels().size() + " Available Hotels";
        	for (Hotel hotel : hotelOffers.getOffers().getHotels()) {
            	decodeHotelInfoUrl(hotel);
    		}
        } else {
        	message = "No offers matches your search criteria";
        }
        return new ModelAndView("offersSearch", "message", message);
    }

    /*
     * Decodes %3A and %2F characters to : and / respectively 
     */
	private void decodeHotelInfoUrl(Hotel hotel) {
		try {
			hotel.getHotelUrls().setHotelInfositeUrl(URLDecoder.decode(hotel.getHotelUrls().getHotelInfositeUrl(), StandardCharsets.UTF_8.name()));
		} catch (UnsupportedEncodingException e) {
			logger.error("Can not decode url" + hotel.getHotelUrls().getHotelInfositeUrl());
			logger.error("Hotel name" + hotel.getHotelInfo().getHotelName());
		}
	}
    
    /*
     * Handle connection exceptions
     */
    @ExceptionHandler(ResourceAccessException.class)
    public ModelAndView handleClientError(ResourceAccessException ex) {
    	return new ModelAndView("error", "message", ex.getMessage());
    }
    
}

