package com.piik.app.service;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;
import org.androidannotations.annotations.rest.RestService;

import android.location.Location;

import com.piik.app.model.PlacesList;
import com.piik.app.rest.PlacesRestClient;

@EBean(scope = Scope.Singleton)
public class PlacesService {

	@RestService
	PlacesRestClient placesRestClient;
	
	private PlacesList currentPlacesList = new PlacesList();
	
	public PlacesList findPlacesNear(final Location location) {
		PlacesList places = placesRestClient.findPlacesNearByLocation(location.getLatitude(), location.getLongitude());
		setCurrentPlacesList(places);
		return places;
	}
	
	public boolean hasCurrentPlaces() {
		return !currentPlacesList.isEmpty();
	}
	
	public PlacesList currentPlacesList() {
		PlacesList places = new PlacesList();
		places.addAll(currentPlacesList);
		return places;
	}

	private void setCurrentPlacesList(final PlacesList places) {
		currentPlacesList.clear();
		currentPlacesList.addAll(places);
	}
	
}
