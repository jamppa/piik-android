package com.piik.app.fragment;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.piik.app.R;

@EFragment(R.layout.fragment_piik)
public class PiikFragment extends Fragment {

	private PiikListener piikListener;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if(activity != null){
			this.piikListener = (PiikListener) activity;
		}
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
	
	public interface PiikListener {
		public void onNextPiikButtonClicked();
		public void onPreviousPiikButtonClicked();
	}
}
