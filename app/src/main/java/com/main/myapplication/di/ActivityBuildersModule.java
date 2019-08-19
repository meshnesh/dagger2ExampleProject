package com.main.myapplication.di;

import com.main.myapplication.AuthActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeActivity();

    @Provides
    static String someString(){
        return "this is a test string";
    }
}
