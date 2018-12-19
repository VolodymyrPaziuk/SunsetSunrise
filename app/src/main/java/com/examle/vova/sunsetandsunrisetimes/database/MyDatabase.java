package com.examle.vova.sunsetandsunrisetimes.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Room;



@Database(entities = {SunriseSunset.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class MyDatabase extends RoomDatabase {
    // singleton
    private static volatile MyDatabase INSTANCE;
    public abstract SunriseSunsetDao locationDao();
}
