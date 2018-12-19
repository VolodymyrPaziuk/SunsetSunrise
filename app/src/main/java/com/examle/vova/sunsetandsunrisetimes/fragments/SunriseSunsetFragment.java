package com.examle.vova.sunsetandsunrisetimes.fragments;

import android.Manifest;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.examle.vova.sunsetandsunrisetimes.App;
import com.examle.vova.sunsetandsunrisetimes.R;
import com.examle.vova.sunsetandsunrisetimes.activities.PlaceAutoCompleteAdapter;
import com.examle.vova.sunsetandsunrisetimes.database.SunriseSunset;
import com.examle.vova.sunsetandsunrisetimes.view_models.SunriseSunsetViewModel;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

import static android.content.ContentValues.TAG;

public class SunriseSunsetFragment extends Fragment implements PlaceSelectionListener {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private SunriseSunsetViewModel viewModel;



    @BindView(R.id.fragment_location) TextView location;
    @BindView(R.id.fragment_sunrise_value) TextView sunrise;
    @BindView(R.id.fragment_sunset_value) TextView sunset;
    @BindView(R.id.fragment_day_length_value) TextView dayLength;

    private String mlongitude;
    private String mLatitude;


    public SunriseSunsetFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sunshine_sunset, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.configureDagger();

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getActivity().getFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        autocompleteFragment.setOnPlaceSelectedListener(this);
       // this.configureViewModel();


    }

    @Override
    public void onPlaceSelected(Place place) {
        Log.i(TAG, "Place Selected: " + place.getName());

        mLatitude = Double.toString(place.getLatLng().latitude);
        mlongitude = Double.toString(place.getLatLng().longitude);

        CharSequence attributions = place.getAttributions();
        if (!TextUtils.isEmpty(attributions)) {
            location.setText(Html.fromHtml(attributions.toString()));
        } else {
            location.setText("");
        }

       // if(viewModel== null){
      //  this.configureViewModel();
       // }

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SunriseSunsetViewModel.class);
        viewModel.init(mLatitude,mlongitude);

        viewModel.getSunriseSunset().observe(this, data -> updateUI(data));

    }


    @Override
    public void onError(Status status) {
        Log.e(TAG, "onError: Status = " + status.toString());
        Toast.makeText(App.context, "Place selection failed: " + status.getStatusMessage(), Toast.LENGTH_SHORT).show();
    }




    private void configureDagger(){
        AndroidSupportInjection.inject(this);
    }

    private void configureViewModel(){
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SunriseSunsetViewModel.class);
        viewModel.init(mLatitude,mlongitude);

        viewModel.getSunriseSunset().observe(this, data -> updateUI(data));
    }




    private void updateUI(@Nullable SunriseSunset data){
        if (data != null){
            this.sunrise.setText(data.getSunrise());
            this.sunset.setText(data.getSunset());
            this.dayLength.setText(data.getDayLength());
        }
    }





}
