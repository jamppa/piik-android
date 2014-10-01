//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.0.1.
//


package com.piik.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.piik.app.R.layout;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class PiikFragment_
    extends PiikFragment
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();
    private View contentView_;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
    }

    public View findViewById(int id) {
        if (contentView_ == null) {
            return null;
        }
        return contentView_.findViewById(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView_ = super.onCreateView(inflater, container, savedInstanceState);
        if (contentView_ == null) {
            contentView_ = inflater.inflate(layout.fragment_piik, container, false);
        }
        return contentView_;
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static PiikFragment_.FragmentBuilder_ builder() {
        return new PiikFragment_.FragmentBuilder_();
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        address = ((TextView) hasViews.findViewById(com.piik.app.R.id.address));
        distance = ((TextView) hasViews.findViewById(com.piik.app.R.id.distance));
        photo = ((ImageView) hasViews.findViewById(com.piik.app.R.id.photo));
        name = ((TextView) hasViews.findViewById(com.piik.app.R.id.name));
        hotness = ((ImageView) hasViews.findViewById(com.piik.app.R.id.place_hotness));
        {
            View view = hasViews.findViewById(com.piik.app.R.id.next_piik_btn);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        PiikFragment_.this.nextPiikBtnClicked();
                    }

                }
                );
            }
        }
        {
            View view = hasViews.findViewById(com.piik.app.R.id.previous_piik_btn);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        PiikFragment_.this.previousPiikBtnClicked();
                    }

                }
                );
            }
        }
        initView();
    }

    public static class FragmentBuilder_ {

        private Bundle args_;

        private FragmentBuilder_() {
            args_ = new Bundle();
        }

        public PiikFragment build() {
            PiikFragment_ fragment_ = new PiikFragment_();
            fragment_.setArguments(args_);
            return fragment_;
        }

    }

}
