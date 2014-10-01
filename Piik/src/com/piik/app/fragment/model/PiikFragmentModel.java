package com.piik.app.fragment.model;

import com.piik.app.model.Location;
import com.piik.app.model.Photo;

import android.os.Bundle;

public class PiikFragmentModel {

	private final Bundle bundle;
	
	public PiikFragmentModel(Bundle placeBundle) {
		this.bundle = placeBundle;
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
	
}
