package com.piik.app.rest;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import com.piik.app.model.PlacesList;

@Rest(rootUrl="http://80.240.137.139:8080/api", converters = {GsonHttpMessageConverter.class})
public interface PlacesRestClient {

	@Get("/places?lat={lat}&lon={lon}")
	PlacesList findPlacesNearByLocation(final double lat, final double lon);
	
}
