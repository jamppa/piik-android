package com.piik.app;

import org.androidannotations.annotations.EBean;

import com.piik.app.model.Place;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;

@EBean
public class ActivityLauncher {

	public void launchMainActivity(final Activity activity) {
		Intent i = new Intent(activity, MainActivity_.class);
		activity.startActivity(i);
	}
	
	public void launchLocationServicesSettings(final Activity activity) {
		Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		activity.startActivity(i);
	}
	
	public void launchMap(final Activity activity, final Place place) {
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(place.asMapUri());
		i.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
		activity.startActivity(i);
	}
}
