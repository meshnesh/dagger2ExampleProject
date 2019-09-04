package com.main.myapplication.di.main;

import com.main.myapplication.network.main.MainApi;
import com.main.myapplication.ui.main.posts.PostRecyclerAdapter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @Provides
    static PostRecyclerAdapter providerAdapter() {
        return new PostRecyclerAdapter();
    }

    @Provides
    static MainApi provideMainApi(Retrofit retrofit){
        return retrofit.create(MainApi.class);
    }


}