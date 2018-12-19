package com.examle.vova.sunsetandsunrisetimes.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

@Entity
public class SunriseSunset {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @SerializedName("id")
    private int id;


    @SerializedName("longitude")
    private String longitude;

    @SerializedName("latitude")
    private String latitude;

    //@PrimaryKey
    //@NonNull
    @SerializedName("sunrise")
    @Expose
    private String sunrise;

    @SerializedName("sunset")
    @Expose
    private String sunset;

    @SerializedName("solar_noon")
    @Expose
    private String solarNoon;

    @SerializedName("day_length")
    @Expose
    private String dayLength;

    @SerializedName("civil_twilight_begin")
    @Expose
    private String civilTwilightBegin;

    @SerializedName("civil_twilight_end")
    @Expose
    private String civilTwilightEnd;

    @SerializedName("nautical_twilight_begin")
    @Expose
    private String nauticalTwilightBegin;

    @SerializedName("nautical_twilight_end")
    @Expose
    private String nauticalTwilightEnd;

    @SerializedName("astronomical_twilight_begin")
    @Expose
    private String astronomicalTwilightBegin;

    @SerializedName("astronomical_twilight_end")
    @Expose
    private String astronomicalTwilightEnd;

    private Date lastRefresh;


    public SunriseSunset(){}

    public SunriseSunset(int id, String sunrise, String sunset, String solarNoon, String dayLength, String civilTwilightBegin, String civilTwilightEnd, String nauticalTwilightBegin, String nauticalTwilightEnd, String astronomicalTwilightBegin, String astronomicalTwilightEnd, Date lastRefresh) {
        this.id = id;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.solarNoon = solarNoon;
        this.dayLength = dayLength;
        this.civilTwilightBegin = civilTwilightBegin;
        this.civilTwilightEnd = civilTwilightEnd;
        this.nauticalTwilightBegin = nauticalTwilightBegin;
        this.nauticalTwilightEnd = nauticalTwilightEnd;
        this.astronomicalTwilightBegin = astronomicalTwilightBegin;
        this.astronomicalTwilightEnd = astronomicalTwilightEnd;
        this.lastRefresh = lastRefresh;
    }


    public SunriseSunset( String sunrise, String sunset, String solarNoon, String dayLength, String civilTwilightBegin, String civilTwilightEnd, String nauticalTwilightBegin, String nauticalTwilightEnd, String astronomicalTwilightBegin, String astronomicalTwilightEnd) {
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.solarNoon = solarNoon;
        this.dayLength = dayLength;
        this.civilTwilightBegin = civilTwilightBegin;
        this.civilTwilightEnd = civilTwilightEnd;
        this.nauticalTwilightBegin = nauticalTwilightBegin;
        this.nauticalTwilightEnd = nauticalTwilightEnd;
        this.astronomicalTwilightBegin = astronomicalTwilightBegin;
        this.astronomicalTwilightEnd = astronomicalTwilightEnd;
    }


    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Date getLastRefresh() {
        return lastRefresh;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getSolarNoon() {
        return solarNoon;
    }

    public void setSolarNoon(String solarNoon) {
        this.solarNoon = solarNoon;
    }

    public String getDayLength() {
        return dayLength;
    }

    public void setDayLength(String dayLength) {
        this.dayLength = dayLength;
    }

    public String getCivilTwilightBegin() {
        return civilTwilightBegin;
    }

    public void setCivilTwilightBegin(String civilTwilightBegin) {
        this.civilTwilightBegin = civilTwilightBegin;
    }

    public String getCivilTwilightEnd() {
        return civilTwilightEnd;
    }

    public void setCivilTwilightEnd(String civilTwilightEnd) {
        this.civilTwilightEnd = civilTwilightEnd;
    }

    public String getNauticalTwilightBegin() {
        return nauticalTwilightBegin;
    }

    public void setNauticalTwilightBegin(String nauticalTwilightBegin) {
        this.nauticalTwilightBegin = nauticalTwilightBegin;
    }

    public String getNauticalTwilightEnd() {
        return nauticalTwilightEnd;
    }

    public void setNauticalTwilightEnd(String nauticalTwilightEnd) {
        this.nauticalTwilightEnd = nauticalTwilightEnd;
    }

    public String getAstronomicalTwilightBegin() {
        return astronomicalTwilightBegin;
    }

    public void setAstronomicalTwilightBegin(String astronomicalTwilightBegin) {
        this.astronomicalTwilightBegin = astronomicalTwilightBegin;
    }

    public String getAstronomicalTwilightEnd() {
        return astronomicalTwilightEnd;
    }

    public void setAstronomicalTwilightEnd(String astronomicalTwilightEnd) {
        this.astronomicalTwilightEnd = astronomicalTwilightEnd;
    }
    public void setLastRefresh(Date lastRefresh) {
        this.lastRefresh = lastRefresh;
    }

}
