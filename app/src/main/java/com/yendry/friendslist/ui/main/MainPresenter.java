package com.yendry.friendslist.ui.main;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.yendry.friendslist.ui.list.ListPresenter;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by yendry on 4/21/2017.
 */

public class MainPresenter implements MainContract.Presenter{

    MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void getFriends(AccessToken accessToken){

        new GraphRequest(
                accessToken,
                "/me/friends",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {


                    public void onCompleted(final GraphResponse response) {

                        // Intent intent = new Intent(MainActivity.this, FriendsList.class);
                        try {
                            view.showData(response.getJSONObject().getJSONArray("data").toString());

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).executeAsync();

    }

}
