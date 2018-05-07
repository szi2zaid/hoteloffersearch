package com.expedia.assingment.hotel.model;

/**
 * Represent the search criteria available for the user
 * 
 * @author zaid
 *
 */
public class OfferSearchCriteria {
	private String minTripStartDate;
	private String maxTripStartDate;
	private Double minStarRating;
	private Double maxStarRating;
	private String cityName;
	private Integer lengthOfStay;
	private Integer minTotalRate;
	private Integer maxTotalRate;
	private Double minGuestRating;
	private Double maxGuestRating;
	
		
	public String getMinTripStartDate() {
		return minTripStartDate;
	}
	public void setMinTripStartDate(String minTripStartDate) {
		this.minTripStartDate = minTripStartDate;
	}
	public String getMaxTripStartDate() {
		return maxTripStartDate;
	}
	public void setMaxTripStartDate(String maxTripStartDate) {
		this.maxTripStartDate = maxTripStartDate;
	}
	public Double getMinStarRating() {
		return minStarRating;
	}
	public void setMinStarRating(Double minStarRating) {
		this.minStarRating = minStarRating;
	}
	public Double getMaxStarRating() {
		return maxStarRating;
	}
	public void setMaxStarRating(Double maxStarRating) {
		this.maxStarRating = maxStarRating;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getMinTotalRate() {
		return minTotalRate;
	}
	public void setMinTotalRate(Integer minTotalRate) {
		this.minTotalRate = minTotalRate;
	}
	public Integer getMaxTotalRate() {
		return maxTotalRate;
	}
	public void setMaxTotalRate(Integer maxTotalRate) {
		this.maxTotalRate = maxTotalRate;
	}
	public Double getMinGuestRating() {
		return minGuestRating;
	}
	public void setMinGuestRating(Double minGuestRating) {
		this.minGuestRating = minGuestRating;
	}
	public Double getMaxGuestRating() {
		return maxGuestRating;
	}
	public void setMaxGuestRating(Double maxGuestRating) {
		this.maxGuestRating = maxGuestRating;
	}
	public Integer getLengthOfStay() {
		return lengthOfStay;
	}
	public void setLengthOfStay(Integer lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("minTripStartDate=" + minTripStartDate)
		.append("maxTripStartDate=" + maxTripStartDate)
		.append("minStarRating=" + minStarRating)
		.append("maxStarRating=" + maxStarRating)
		.append("cityName=" + cityName)
		.append("lengthOfStay=" + lengthOfStay)
		.append("minTotalRate=" + minTotalRate)
		.append("maxTotalRate=" + maxTotalRate)
		.append("minGuestRating=" + minGuestRating)
		.append("maxGuestRating=" + maxGuestRating);
		return sb.toString();
	}

}
