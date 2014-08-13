package com.piik.app;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.location.Location;
import android.os.Bundle;

import com.piik.app.service.LocationService;
import com.piik.app.service.LocationService.LocationResultReceiver;
import com.piik.app.service.PlacesService;

@EActivity(R.layout.activity_splash)
public class SplashActivity extends Activity implements LocationResultReceiver {
	
	@Bean
	ActivityLauncher activityLauncher;
	@Bean
	LocationService locationService;
	@Bean
	PlacesService placesService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@AfterViews
	public void init() {
		if(!locationService.hasAccessToAnyProvider()){
			showAlertBoxForEnablingLocationServices();
			return;
		}
		locationService.getLocation(this);
	}

	private void showAlertBoxForEnablingLocationServices() {
		AlertDialog dialog = buildAlertDialog();
		dialog.show();
	}

	private AlertDialog buildAlertDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_LIGHT);
		builder.setTitle("Enable Location services")
			.setMessage("Your location services seems to be disabled. Enable them and try again?");
		
		builder.setPositiveButton("Enable", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				activityLauncher.launchLocationServicesSettings(SplashActivity.this);
				finish();
			}
		});
		
		builder.setNegativeButton("No thanks", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
				finish();
			}
		});
		return builder.create();
	}

	@Override
	@Background
	public void gotLocation(Location location) {
		placesService.findPlacesNear(location);
		activityLauncher.launchMainActivity(this);
		finish();
	}

}
