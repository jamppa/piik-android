//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.0.1.
//


package com.piik.app.service;

import android.content.Context;
import com.piik.app.rest.PlacesRestClient_;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class PlacesService_
    extends PlacesService
{

    private Context context_;
    private static PlacesService_ instance_;

    private PlacesService_(Context context) {
        context_ = context;
    }

    public static PlacesService_ getInstance_(Context context) {
        if (instance_ == null) {
            OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(null);
            instance_ = new PlacesService_(context.getApplicationContext());
            instance_.init_();
            OnViewChangedNotifier.replaceNotifier(previousNotifier);
        }
        return instance_;
    }

    private void init_() {
        placesRestClient = new PlacesRestClient_();
    }

}
