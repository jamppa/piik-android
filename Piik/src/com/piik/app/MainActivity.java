package com.piik.app;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.piik.app.adapter.PiikPagerAdapter;
import com.piik.app.fragment.PiikFragment.PiikListener;
import com.piik.app.service.PlacesService;

@EActivity(R.layout.activity_main)
public class MainActivity extends FragmentActivity implements PiikListener {

	PiikPagerAdapter piikPagerAdapter;
	
	@Bean
	PlacesService placesService;
	
	@ViewById(R.id.pager)
	ViewPager viewPager;
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		piikPagerAdapter = new PiikPagerAdapter(getSupportFragmentManager(), placesService.currentPlacesList());
	}
	
	@AfterViews
	public void initViewPager(){
		viewPager.setAdapter(piikPagerAdapter);
	}

	@Override
	public void onNextPiikButtonClicked() {
		viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
	}

	@Override
	public void onPreviousPiikButtonClicked() {
		viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
	}
	
}
