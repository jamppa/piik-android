package com.piik.app.fragment.model;

import java.util.HashMap;
import java.util.Map;

import com.piik.app.R;
import com.piik.app.model.Location;
import com.piik.app.model.Photo;

import android.os.Bundle;

public class PiikFragmentModel {

	private final Bundle bundle;
	private final Map<String, Integer> hotnessResources = new HashMap<String, Integer>();
	private final Map<String, String> hotnessTexts = new HashMap<String, String>();
	
	public PiikFragmentModel(Bundle placeBundle) {
		this.bundle = placeBundle;
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

	public String placeName() {
		return bundle.getString("name");
	}
	
	public String placeAddress() {
		return ((Location)bundle.getSerializable("location")).address;
	}
	
	public String placeDistance() {
		return ((Location)bundle.getSerializable("location")).distance + " meters";
	}
	
	public String placePhotoUrl() {
		return ((Photo)bundle.getSerializable("photo")).fullUrl;
	}
	
	public int hotnessResource() {
		return hotnessResources.get(bundle.getString("hotness"));
	}
	
	public String hotnessText() {
		return hotnessTexts.get(bundle.getString("hotness"));
	}
	
}
