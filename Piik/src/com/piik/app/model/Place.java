package com.piik.app.model;

import android.os.Bundle;

public class Place {
	
	public String id;
	public String name;
	public Location location;
	
	public Bundle asBundle() {
		Bundle b = new Bundle();
		b.putString("id", id);
		b.putString("name", name);
		b.putSerializable("location", location);
		return b;
	}

}
