package com.examle.vova.sunsetandsunrisetimes.view_models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.examle.vova.sunsetandsunrisetimes.database.SunriseSunset;
import com.examle.vova.sunsetandsunrisetimes.repositories.SunriseSunsetRepository;

import javax.inject.Inject;


public class SunriseSunsetViewModel extends ViewModel{
    //private MutableLiveData<SunriseSunset> sunriseSunset;
    private LiveData<SunriseSunset> sunriseSunset;
    private SunriseSunsetRepository sunriseSunsetRepo;

    @Inject
    public SunriseSunsetViewModel(SunriseSunsetRepository sunriseSunsetRepo) {
        this.sunriseSunsetRepo = sunriseSunsetRepo;

    }



    public void init(String latitude, String longitude ) {
       // if (this.sunriseSunset != null) {
       //     return;
       // }

        sunriseSunset =  sunriseSunsetRepo.getSunriseSunset(latitude, longitude);
    }




    public LiveData<SunriseSunset> getSunriseSunset() {
        return this.sunriseSunset;
    }
}
