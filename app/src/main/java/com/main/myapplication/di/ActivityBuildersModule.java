package com.main.myapplication.di;

import com.main.myapplication.di.auth.AuthViewModelsModule;
import com.main.myapplication.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class}
    )
    abstract AuthActivity contributeActivity();
}
