package com.examle.vova.sunsetandsunrisetimes.dependency_injection.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.examle.vova.sunsetandsunrisetimes.database.SunriseSunset;
import com.examle.vova.sunsetandsunrisetimes.dependency_injection.ViewModelKey;
import com.examle.vova.sunsetandsunrisetimes.view_models.FactoryViewModel;
import com.examle.vova.sunsetandsunrisetimes.view_models.SunriseSunsetViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SunriseSunsetViewModel.class)
    abstract ViewModel bindSunriseSunsetViewModel(SunriseSunsetViewModel repoViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(FactoryViewModel factory);

}
