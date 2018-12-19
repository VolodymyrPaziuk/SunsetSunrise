package com.examle.vova.sunsetandsunrisetimes.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.examle.vova.sunsetandsunrisetimes.App;
import com.examle.vova.sunsetandsunrisetimes.R;
import com.examle.vova.sunsetandsunrisetimes.api.SunriseSunsetWebservice;
import com.examle.vova.sunsetandsunrisetimes.database.SunriseSunset;
import com.examle.vova.sunsetandsunrisetimes.database.SunriseSunsetDao;
import com.examle.vova.sunsetandsunrisetimes.database.SunriseSunsetResponse;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class SunriseSunsetRepository {

    private static int REFRESH_TIMEOUT_IN_MINUTES = 1;

    private final SunriseSunsetWebservice webservice;
    private final SunriseSunsetDao sunriseSunsetDao;
    private final Executor executor;

    @Inject
    public SunriseSunsetRepository(SunriseSunsetWebservice webservice, SunriseSunsetDao sunriseSunsetDao, Executor executor) {
        this.webservice = webservice;
        this.sunriseSunsetDao = sunriseSunsetDao;
        this.executor = executor;
    }



    public LiveData<SunriseSunset> getSunriseSunset(String locationLatitude, String locationLongitude) {
        refreshSunriseSunset(locationLatitude,locationLongitude);
        Toast.makeText(App.context, "data refreshed from db ", Toast.LENGTH_SHORT).show();
        return sunriseSunsetDao.load( locationLatitude, locationLongitude);

    }



    private void refreshSunriseSunset(final String locationLatitude, final String locationLongitude) {
        executor.execute(() -> {
            // Check data
            boolean sunriseSunsetExist =(sunriseSunsetDao.hasData(locationLatitude, locationLongitude,getMaxRefreshTime(new Date())) != null);
            if (!sunriseSunsetExist) {
                webservice.getSunriseSunset(locationLatitude, locationLongitude).enqueue(new Callback<SunriseSunsetResponse>() {
                    @Override
                    public void onResponse(Call<SunriseSunsetResponse> call, Response<SunriseSunsetResponse> response) {
                        Log.e("TAG", "data refreeshed from network");
                        Toast.makeText(App.context, "data refreshed from network ", Toast.LENGTH_SHORT).show();
                        executor.execute(() -> {
                            SunriseSunset sunriseSunset = response.body().getSunriseSunset();
                            sunriseSunset.setLongitude(locationLongitude);
                            sunriseSunset.setLatitude(locationLatitude);
                            sunriseSunset.setLastRefresh(new Date());
                           sunriseSunsetDao.save(sunriseSunset);

                        });
                    }
                    @Override
                    public void onFailure(Call<SunriseSunsetResponse> call, Throwable t) { }
                });
            }
        });
    }


    private Date getMaxRefreshTime(Date currentDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MINUTE, -REFRESH_TIMEOUT_IN_MINUTES);
        return cal.getTime();
    }
}
