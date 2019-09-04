package com.main.myapplication.di.main;


import androidx.lifecycle.ViewModel;

import com.main.myapplication.di.ViewModelKey;
import com.main.myapplication.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);
}
