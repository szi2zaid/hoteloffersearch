package com.expedia.assingment.hotel.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.expedia.assingment.hotel.model.OfferSearchCriteria;
import com.expedia.assingment.hotel.model.json.HotelOffers;

/**
 * @see BookstoreService
 * 
 * @author zaid
 *
 */
@Service("hotelFinderService")
public class HotelFinderServiceImpl implements HotelFinderService {

	private Logger logger = Logger.getLogger(HotelFinderServiceImpl.class);

	/**
     * Find the {@link HotelOffers}s for a given {@link OfferSearchCriteria}.
     * 
     * @param criteria the OfferSearchCriteria
     * @return the list of HotelOffers
     */
	@Override
	public HotelOffers findOffers(OfferSearchCriteria serchCriteria) {
		String uri = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";
		logger.trace("base URI :" + uri);
        uri = addSearchParametersToUrl(serchCriteria, uri);
        logger.trace("updated URI :" + uri);
        logger.trace("getting RestTemplate");
        RestTemplate restTemplate = new RestTemplate();
        logger.trace("before calling Rest Service");
        return restTemplate.getForObject(uri, HotelOffers.class);
	}

	/**
     * Add the search parameters to the REST URI based on the serchCriteria {@link OfferSearchCriteria}.
     * 
     * @param criteria the OfferSearchCriteria
     * @param uri the uri String
     * @return the updated uri String
     */
	private String addSearchParametersToUrl(OfferSearchCriteria serchCriteria, String uri) {
		StringBuffer sb = new StringBuffer(uri);
		if (serchCriteria.getCityName() != null && !"".equals(serchCriteria.getCityName()))  {
			sb.append("&destinationCity=" + serchCriteria.getCityName()); 
        }
        if (serchCriteria.getMinTripStartDate() != null && !"".equals(serchCriteria.getMinTripStartDate())) {
        	sb.append("&minTripStartDate=" + serchCriteria.getMinTripStartDate()); 
        }
        if (serchCriteria.getMaxTripStartDate() != null && !"".equals(serchCriteria.getMaxTripStartDate())) {
        	sb.append("&maxTripStartDate=" + serchCriteria.getMaxTripStartDate()); 
        }
        if (serchCriteria.getLengthOfStay() != null ) {
        	sb.append("&lengthOfStay=" + serchCriteria.getLengthOfStay()); 
        }
        if (serchCriteria.getMaxStarRating() != null ) {
        	sb.append("&maxStarRating=" + serchCriteria.getMaxStarRating()); 
        }
        if (serchCriteria.getMinStarRating() != null ) {
        	sb.append("&minStarRating=" + serchCriteria.getMinStarRating()); 
        }
        if (serchCriteria.getMaxTotalRate() != null ) {
        	sb.append("&maxTotalRate=" + serchCriteria.getMaxTotalRate()); 
        }
        if (serchCriteria.getMinTotalRate() != null ) {
        	sb.append("&minTotalRate=" + serchCriteria.getMinTotalRate()); 
        }
        if (serchCriteria.getMaxGuestRating() != null ) {
        	sb.append("&maxGuestRating=" + serchCriteria.getMaxGuestRating()); 
        }
        if (serchCriteria.getMinGuestRating() != null ) {
        	sb.append("&minGuestRating=" + serchCriteria.getMinGuestRating()); 
        }
		return sb.toString();
	}

}
