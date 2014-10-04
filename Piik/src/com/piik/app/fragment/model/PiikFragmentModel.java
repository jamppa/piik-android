package com.piik.app.fragment.model;

import java.util.HashMap;
import java.util.Map;

import com.piik.app.R;
import com.piik.app.model.Place;

public class PiikFragmentModel {

	private final Place place;
	private final Map<String, Integer> hotnessResources = new HashMap<String, Integer>();
	private final Map<String, String> hotnessTexts = new HashMap<String, String>();
	
	public PiikFragmentModel(Place place) {
		this.place = place;
		setupHotnessResources();
		setupHotnessTexts();
	}

	private void setupHotnessTexts() {
		hotnessTexts.put("not", "This place is cold as balls :/");
		hotnessTexts.put("semi", "There could be something going on here...");
		hotnessTexts.put("hot", "This place is hot as hell!");
	}

	private void setupHotnessResources() {
		hotnessResources.put("not", R.drawable.container_circle_not_hot);
		hotnessResources.put("semi", R.drawable.container_circle_semi_hot);
		hotnessResources.put("hot", R.drawable.container_circle_hot);
	}
	
	public Place place() {
		return place;
	}

	public String placeName() {
		return place.name;
	}
	
	public String placeAddress() {
		return place.location.address;
	}
	
	public String placeDistance() {
		return place.location.distance + " meters";
	}
	
	public String placePhotoUrl() {
		return place.photo.fullUrl;
	}
	
	public int hotnessResource() {
		return hotnessResources.get(place.hotness);
	}
	
	public String hotnessText() {
		return hotnessTexts.get(place.hotness);
	}
	
}
