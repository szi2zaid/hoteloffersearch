package com.expedia.assingment.hotel.service;

import com.expedia.assingment.hotel.model.json.HotelOffers;
import com.expedia.assingment.hotel.model.OfferSearchCriteria;

/**
 * Main entry point for the REST API.
 * 
 * @author zaid
 *
 */
public interface HotelFinderService {
	
	/**
     * Find the {@link HotelOffers}s for a given {@link OfferSearchCriteria}.
     * 
     * @param criteria the OfferSearchCriteria
     * @return HotelOffers
     */
	public HotelOffers findOffers(OfferSearchCriteria criteria) ;
}
