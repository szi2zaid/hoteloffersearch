<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<title>Hotels Offers Finder</title>
<link rel="shortcut icon"
	href="http://static02.hongkiat.com/logo/hkdc/favicon.ico">
<link rel="icon"
	href="http://static02.hongkiat.com/logo/hkdc/favicon.ico">
<link rel="stylesheet" type="text/css" media="all"
	href="resources/css/style.css">
<link rel="stylesheet" type="text/css" media="all"
	href="resources/css/responsive.css">

</head>

<body>
	<h2>Hotels Offers Finder</h2>
	<section id="container">

		<form:form name="hongkiat" id="hongkiat-form" action="hotelOffer.html"
			method="GET" commandName="offerSearchCriteria">
			<div id="wrapping" class="clearfix">
				<section id="aligned">
					<table style="width: 100%;">
						<tr>
							<td class="label">Destination</td>
							<td ><form:input path="cityName" type="text"
									placeholder="City Name" autocomplete="off" tabindex="1"
									class="txtinput" /></td>
							<td class="label">Length Of Stay</td>
							<td><form:input path="lengthOfStay" class="txtinput"
									type="number" step="1" min="1" placeholder="Length Of Stay" name="firstname" tabindex="2" /></td>
						</tr>
						<tr>
							<td class="label">Trip Start Date</td>
							<td><form:input path="minTripStartDate" type="date"
									placeholder="Trip Start Date" autocomplete="off" tabindex="3"
									class="txtinput" /></td>
							<td class="label">Trip End Date</td>
							<td><form:input path="maxTripStartDate" type="date"
									placeholder="Trip End Date" autocomplete="off" tabindex="4"
									class="txtinput" /></td>
						</tr>
						<tr>
							<td class="label">Min Star Rating</td>
							<td><form:input path="minStarRating" class="txtinput"
									type="number" step="1" min="0" max="5" placeholder="Min Star Rating" tabindex="5"/></td>
							<td class="label">Max Star Rating</td>
							<td><form:input path="maxStarRating" class="txtinput"
									type="number" step="1" min="0" max="5" placeholder="Max Star Rating" tabindex="6"/></td>
						</tr>
						<tr>
							<td class="label">Min Guest Rating</td>
							<td><form:input path="minGuestRating" class="txtinput"
									type="number" step="1" min="0" placeholder="Min Guest Rating" tabindex="7" /></td>
							<td class="label">Max Guest Rating</td>
							<td><form:input path="maxGuestRating" class="txtinput"
									type="number" step="1" min="0" placeholder="Max Guest Rating" tabindex="8" /></td>
						</tr>
						<tr>
							<td class="label">Min Total Rate</td>
							<td><form:input path="minTotalRate" class="txtinput"
									type="number" step="1" min="0" tabindex="9" placeholder="Min Total Rate"/> </td>
							<td class="label">Max Total Rate</td>
							<td><form:input path="maxTotalRate" class="txtinput"
									type="number" step="1" min="0" tabindex="10" placeholder="Max Total Rate"  /></td>
						</tr>
					</table>

				</section>


			</div>


			<section id="buttons">
				<input type="reset" name="reset" id="resetbtn" class="resetbtn" tabindex="11"
					value="Reset"> <input type="submit" name="submit"
					id="submitbtn" class="submitbtn" tabindex="12" value="Find Offers">
				<br style="clear: both;">
			</section>
			<br />
			<br />
			

				<section style="width: 100%; font-size: 14px; font-weight: bold;">
					${message}
				</section>
				<br />
			<c:if test="${not empty hotelList}">
				<section style="width: 100%; font-size: 14px; font-weight: bold;">
					<table style="width: 100%;" border="1px solid #dedede;"
					webkit-box-shadow=" 0 1px 3px rgba(0, 0, 0, 0.1) inset" 
					
						cellspacing="10px" cellpadding="10px">
						<tr>
							<th>Hotel</th>
							<th>Offer Date Range</th>
							<th>Price Information</th>
							<th>Location</th>
						</tr>
						<c:forEach items="${hotelList}" var="hotel">

							<tr>
								<td><a target="blank"
									href="${hotel.hotelUrls.hotelInfositeUrl}">
										<img src="${hotel.hotelInfo.hotelImageUrl}" width="150px" />
								</a>
									<h3>${hotel.hotelInfo.hotelName}</h3>
									<article>
									<div>Star Rating
											${hotel.hotelInfo.hotelStarRating}</div>
										<div>Guest Rating
											${hotel.hotelInfo.hotelGuestReviewRating}</div>
										<div>Total Review ${hotel.hotelInfo.hotelReviewTotal}</div>
										
										<div>${(hotel.hotelInfo.vipAccess == true) ? 'VIP Access' : ''}
										</div>
									</article></td>
								<td width="220px">
									<article>
										<table>
											<tr>
												<td>From</td>
												<td>${hotel.offerDateRange.travelStartDate}</td>
											</tr>
											<tr>
												<td>To</td>
												<td>${hotel.offerDateRange.travelEndDate}</td>
											</tr>
											<tr>
												<td>Length Of Stay</td>
												<td>${hotel.offerDateRange.lengthOfStay}</td>
											</tr>
										</table>
									</article>
								</td>
								<td width="220px">
									<article>
										<table>
											<tr>
												<td>Average Price Value</td>
												<td>${hotel.hotelPricingInfo.averagePriceValue}</td>
											</tr>
											<tr>
												<td>Original Price Per Night</td>
												<td>${hotel.hotelPricingInfo.originalPricePerNight}</td>
											</tr>
											<tr>
												<td>Total Price Value</td>
												<td>${hotel.hotelPricingInfo.totalPriceValue}</td>
											</tr>
											<tr>
												<td>Percent Savings</td>
												<td><fmt:formatNumber type="number"
														minFractionDigits="2" maxFractionDigits="2"
														value="${hotel.hotelPricingInfo.percentSavings/100.00}" />%</td>
											</tr>
											<tr>
												<td>currency</td>
												<td>${hotel.hotelPricingInfo.currency}</td>
											</tr>

										</table>
									</article>
								</td>
								<td>
									<article>
										<table>
											<tr>
												<td>${hotel.destination.country}</td>
											</tr>
											<tr>
												<td>${hotel.destination.province}</td>
											</tr>
											<tr>
												<td>${hotel.hotelInfo.hotelLongDestination}</td>
											</tr>
											<tr>
												<td>${hotel.hotelInfo.hotelStreetAddress}</td>
											</tr>
										</table>
										<a target="blank"
											href="https://www.google.com/maps/?q=${hotel.hotelInfo.hotelLatitude},${hotel.hotelInfo.hotelLongitude}">
											check map</a>
									</article>
								</td>
							</tr>
						</c:forEach>
					</table>
				</section>
			</c:if>

		</form:form>
	</section>
</body>
</html>