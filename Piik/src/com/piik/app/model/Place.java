package com.piik.app.model;

import android.os.Bundle;

public class Place {
	
	public String id;
	public String name;
	public Location location;
	public Photo photo;
	public String hotness;
	
	public Bundle asBundle() {
		Bundle b = new Bundle();
		b.putString("id", id);
		b.putString("name", name);
		b.putSerializable("location", location);
		b.putSerializable("photo", photo);
		b.putSerializable("hotness", hotness);
		return b;
	}

}
