package com.main.myapplication.di.auth;

import androidx.lifecycle.ViewModel;

import com.main.myapplication.di.ViewModelKey;
import com.main.myapplication.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);
}
