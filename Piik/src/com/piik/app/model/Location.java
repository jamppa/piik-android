package com.piik.app.model;

import java.io.Serializable;

public class Location implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String address;
	public double lat;
	public double lng;
	public int distance;
}
