package com.piik.app;

import org.androidannotations.annotations.EBean;

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
	
}
