package com.piik.app.model;

import java.io.Serializable;
import java.util.Locale;

import android.net.Uri;
import android.os.Bundle;

public class Place implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String id;
	public String name;
	public Location location;
	public Photo photo;
	public String hotness;
	
	public Bundle asBundle() {
		Bundle b = new Bundle();
		b.putSerializable("place", this);
		return b;
	}

	public Uri asMapUri() {
		String uri = String.format(Locale.ENGLISH,"geo:%f,%f?q=%f,%f (%s)", location.lat, location.lng, location.lat, location.lng, name);
		return Uri.parse(uri);
	}

}
