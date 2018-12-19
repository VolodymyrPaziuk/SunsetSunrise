package com.examle.vova.sunsetandsunrisetimes.database;

import com.google.gson.annotations.SerializedName;



public class SunriseSunsetResponse {
    @SerializedName("results")
    private SunriseSunset sunriseSunset;
    @SerializedName("status")
    private String statusCode;

    public SunriseSunset getSunriseSunset() {
        return sunriseSunset;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setSunriseSunset(SunriseSunset daylightEntity) {
        this.sunriseSunset = daylightEntity;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
