package com.piik.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.piik.app.fragment.PiikFragment;
import com.piik.app.model.PlacesList;

public class PiikPagerAdapter extends FragmentStatePagerAdapter {

	private final PlacesList places = new PlacesList();
	
	public PiikPagerAdapter(FragmentManager fm, PlacesList places) {
		super(fm);
		this.places.addAll(places);
	}

	@Override
	public Fragment getItem(int pos) {
		return PiikFragment.newFragment(places.get(pos));
	}

	@Override
	public int getCount() {
		return places.size();
	}
	
}
