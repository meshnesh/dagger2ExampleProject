package com.main.myapplication.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class AuthViewModel extends ViewModel {

    @Inject
    public AuthViewModel() {
        Log.d(TAG, "AuthViewModel: ViewModel is working....");
    }
}
