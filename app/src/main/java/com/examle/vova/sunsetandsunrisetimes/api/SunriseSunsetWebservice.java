package com.examle.vova.sunsetandsunrisetimes.api;

import com.examle.vova.sunsetandsunrisetimes.database.SunriseSunset;
import com.examle.vova.sunsetandsunrisetimes.database.SunriseSunsetResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface SunriseSunsetWebservice {


    @GET("json")
    Call<SunriseSunsetResponse> getSunriseSunset(@Query("lat") String latitude, @Query("lng") String longitude);
}
