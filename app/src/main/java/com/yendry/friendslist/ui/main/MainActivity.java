package com.yendry.friendslist.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.yendry.friendslist.R;
import com.yendry.friendslist.di.component.DaggerMainComponent;
import com.yendry.friendslist.di.modules.MainModule;
import com.yendry.friendslist.ui.list.FriendsList;

import java.util.Arrays;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements MainContract.View {

    CallbackManager callbackManager;
    LoginButton loginButton;
    @Inject
    MainContract.Presenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        facebookSDKInitialize();
        setContentView(R.layout.activity_main);
        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(getString(R.string.public_profile), getString(R.string.fb_email), getString(R.string.fb_user_friends)));
        AccessToken at = AccessToken.getCurrentAccessToken();
        getLoginDetails(loginButton);
        checkLogin(at);

    }


    private void checkLogin(AccessToken accessToken) {
        if (accessToken != null) {
            mainPresenter.getFriends(accessToken);
        }
    }

    protected void facebookSDKInitialize() {

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
    }

    protected void getLoginDetails(LoginButton login_button) {

        // Callback registration
        login_button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult login_result) {
                mainPresenter.getFriends(AccessToken.getCurrentAccessToken());

            }

            @Override
            public void onCancel() {
                // code for cancellation
            }

            @Override
            public void onError(FacebookException exception) {
                //  code to handle error
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void showData(String str) {
        Intent intent = new Intent(MainActivity.this, FriendsList.class);
        intent.putExtra("jsondata", str);
        startActivity(intent);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }
}
