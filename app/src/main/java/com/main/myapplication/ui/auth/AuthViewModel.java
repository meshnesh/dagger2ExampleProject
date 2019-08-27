package com.main.myapplication.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.main.myapplication.network.auth.AuthApi;

import javax.inject.Inject;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class AuthViewModel extends ViewModel {

    @Inject
    AuthViewModel(AuthApi authApi) {
        Log.d(TAG, "AuthViewModel: ViewModel is working....");

        if(authApi == null) {
            Log.d(TAG, "AuthViewModel: This Auth API is null...");
        } else {
            Log.d(TAG, "AuthViewModel: This Auth API is not null...");
        }
    }
}
