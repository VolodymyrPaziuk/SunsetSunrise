package com.examle.vova.sunsetandsunrisetimes.dependency_injection.modules;

import com.examle.vova.sunsetandsunrisetimes.fragments.SunriseSunsetFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract SunriseSunsetFragment contributeUserProfileFragment();

}
