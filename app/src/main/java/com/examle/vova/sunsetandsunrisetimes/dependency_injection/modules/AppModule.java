package com.examle.vova.sunsetandsunrisetimes.dependency_injection.modules;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.examle.vova.sunsetandsunrisetimes.api.SunriseSunsetWebservice;
import com.examle.vova.sunsetandsunrisetimes.database.MyDatabase;
import com.examle.vova.sunsetandsunrisetimes.database.SunriseSunsetDao;
import com.examle.vova.sunsetandsunrisetimes.repositories.SunriseSunsetRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



@Module(includes = ViewModelModule.class)
public class AppModule {
    @Provides
    @Singleton
    MyDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application,
                MyDatabase.class, "MyDatabase.db")
                .build();
    }

    @Provides
    @Singleton
    SunriseSunsetDao provideUserDao(MyDatabase database) { return database.locationDao(); }

    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Provides
    @Singleton
    SunriseSunsetRepository provideUserRepository(SunriseSunsetWebservice webservice, SunriseSunsetDao sunriseSunsetDao, Executor executor) {
        return new SunriseSunsetRepository(webservice, sunriseSunsetDao, executor);
    }


    private static String BASE_URL = "https://api.sunrise-sunset.org/";

    @Provides
    Gson provideGson() { return new GsonBuilder().create(); }

    @Provides
    Retrofit provideRetrofit(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    SunriseSunsetWebservice provideApiWebservice(Retrofit restAdapter) {
        return restAdapter.create(SunriseSunsetWebservice.class);
    }
}
