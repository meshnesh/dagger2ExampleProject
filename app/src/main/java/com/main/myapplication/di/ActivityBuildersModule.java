package com.main.myapplication.di;

import com.main.myapplication.di.auth.AuthModule;
import com.main.myapplication.di.auth.AuthViewModelsModule;
import com.main.myapplication.di.main.MainFragmentBuildersModule;
import com.main.myapplication.di.main.MainViewModelsModule;
import com.main.myapplication.ui.auth.AuthActivity;
import com.main.myapplication.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class, AuthModule.class}
    )
    abstract AuthActivity contributeActivity();

    @ContributesAndroidInjector(
            modules = {MainFragmentBuildersModule.class, MainViewModelsModule.class}
    )
    abstract MainActivity contributeMainActivity();
}
