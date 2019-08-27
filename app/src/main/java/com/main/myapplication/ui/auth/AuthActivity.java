package com.main.myapplication.ui.auth;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.RequestManager;
import com.main.myapplication.R;
import com.main.myapplication.model.User;
import com.main.myapplication.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity implements View.OnClickListener {

    private AuthViewModel viewModel;

    private EditText userId;

    private static final String TAG = "AuthActivity";

    private ProgressBar progressBar;

    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        userId = findViewById(R.id.user_id_input);
        progressBar = findViewById(R.id.progress_bar);

        findViewById(R.id.login_button).setOnClickListener(this);

        viewModel = ViewModelProviders.of(this, providerFactory).get(AuthViewModel.class);

        setLogo();
        subscribeObservers();
    }

    private void subscribeObservers() {
       viewModel.observeAuthState().observe(this, new Observer<AuthResource<User>>() {
           @Override
           public void onChanged(AuthResource<User> userAuthResource) {
               if (userAuthResource != null) {
                   switch (userAuthResource.status) {
                       case LOADING: {
                           showProgressBar(true);
                           break;
                       }
                       case ERROR: {
                           Toast.makeText(AuthActivity.this, userAuthResource.message +
                                   "\nDid you enter a number between 1 and 10?", Toast.LENGTH_SHORT).show();
                           showProgressBar(false);
                           break;
                       }
                       case AUTHENTICATED: {
                           showProgressBar(false);
                           Log.d(TAG, "onChanged: Login success: " + userAuthResource.data.getEmail());
                           break;
                       }
                       case NOT_AUTHENTICATED: {
                           showProgressBar(false);
                           break;
                       }
                   }
               }
           }
       });
    }

    private void showProgressBar(boolean isVisible) {
        if (isVisible) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    private void setLogo() {
        requestManager
                .load(logo)
                .into((ImageView)findViewById(R.id.login_logo));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button: {

                attemptLogin();
                break;
            }
        }
    }

    private void attemptLogin() {

        if (TextUtils.isEmpty(userId.getText().toString())) {
            return;
        }
        viewModel.authenticateWithid(Integer.parseInt(userId.getText().toString()));
    }
}