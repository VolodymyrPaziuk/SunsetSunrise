package com.examle.vova.sunsetandsunrisetimes.dependency_injection.modules;

import com.examle.vova.sunsetandsunrisetimes.activities.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract MainActivity contributeMainActivity();
}