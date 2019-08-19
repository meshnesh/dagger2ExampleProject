package com.main.myapplication.di;

import android.app.Application;

import com.main.myapplication.BaseApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


@Component(
        modules = {
                AndroidSupportInjectionModule.class,
        })
public interface AppComponent extends AndroidInjector<BaseApplication> {

@Component.Builder
interface Builder{

    @BindsInstance
    Builder application(Application application);

    AppComponent build();
}
}