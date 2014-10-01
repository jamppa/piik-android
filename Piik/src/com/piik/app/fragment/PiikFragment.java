package com.piik.app.fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.piik.app.R;
import com.piik.app.fragment.model.PiikFragmentModel;
import com.piik.app.model.Place;
import com.squareup.picasso.Picasso;

@EFragment(R.layout.fragment_piik)
public class PiikFragment extends Fragment {

	PiikListener piikListener;
	PiikFragmentModel piikFragmentModel;
	
	@ViewById(R.id.name)
	TextView name;
	
	@ViewById(R.id.address)
	TextView address;
	
	@ViewById(R.id.distance)
	TextView distance;
	
	@ViewById(R.id.photo)
	ImageView photo;
		
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if(activity != null){
			this.piikListener = (PiikListener) activity;
		}
	}
	
	@AfterViews
	public void initView() {
		piikFragmentModel = new PiikFragmentModel(getArguments());
		name.setText(piikFragmentModel.placeName());
		address.setText(piikFragmentModel.placeAddress());
		distance.setText(piikFragmentModel.placeDistance());
		Picasso.with(getActivity()).load(piikFragmentModel.placePhotoUrl()).into(photo);
	}
	
	@Click(R.id.next_piik_btn)
	public void nextPiikBtnClicked() {
		notifyListenerOnNextPiikButtonClicked();
	}
	
	@Click(R.id.previous_piik_btn)
	public void previousPiikBtnClicked() {
		notifyListenerOnPreviousPiikButtonClicked();
	}
	
	private void notifyListenerOnPreviousPiikButtonClicked() {
		if(piikListener != null){
			piikListener.onPreviousPiikButtonClicked();
		}
	}

	private void notifyListenerOnNextPiikButtonClicked() {
		if(piikListener != null){
			piikListener.onNextPiikButtonClicked();
		}
	}
	
	public static PiikFragment_ newFragment(final Place place) {
		PiikFragment_ f = new PiikFragment_();
		f.setArguments(place.asBundle());
		return f;
	}
	
	public interface PiikListener {
		public void onNextPiikButtonClicked();
		public void onPreviousPiikButtonClicked();
	}
}
