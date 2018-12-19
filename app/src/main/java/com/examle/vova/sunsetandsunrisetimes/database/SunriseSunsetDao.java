package com.examle.vova.sunsetandsunrisetimes.database;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.Date;


import static android.arch.persistence.room.OnConflictStrategy.REPLACE;


@Dao
public interface SunriseSunsetDao {
    @Insert(onConflict = REPLACE)
    void save(SunriseSunset location);


    @Query("SELECT * FROM sunrisesunset WHERE  latitude = :locationLatitude AND longitude = :locationLongitude")
    LiveData<SunriseSunset> load(String locationLatitude, String locationLongitude);


    @Query("SELECT * FROM sunrisesunset WHERE  latitude = :locationLatitude AND longitude = :locationLongitude AND lastRefresh > :lastRefreshMax LIMIT 1")
    SunriseSunset hasData(String locationLatitude, String locationLongitude, Date lastRefreshMax );

}
