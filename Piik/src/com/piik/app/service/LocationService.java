package com.piik.app.service;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.SystemService;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

@EBean
public class LocationService implements LocationListener {

	@SystemService
	LocationManager locationManager;
	
	LocationResultReceiver locationResultReceiver;
	
	public boolean hasAccessToAnyProvider() {
		return (isGpsProviderEnabled() || isNetworkProviderEnabled());
	}
	
	public boolean isGpsProviderEnabled() {
		return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
	}
	
	public boolean isNetworkProviderEnabled() {
		return locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
	}
	
	public void getLocation(LocationResultReceiver receiver) {
		this.locationResultReceiver = receiver;
		
		Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		if(location == null){
			location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		}
		
		if(location == null){
			locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
		}
		else {
			locationResultReceiver.gotLocation(location);
		}
	}
	
	public interface LocationResultReceiver {
		public void gotLocation(Location location);
	}

	@Override
	public void onLocationChanged(Location location) {
		locationManager.removeUpdates(this);
		if(locationResultReceiver != null){
			locationResultReceiver.gotLocation(location);
		}
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {}

	@Override
	public void onProviderEnabled(String provider) {}

	@Override
	public void onProviderDisabled(String provider) {}
	
}
