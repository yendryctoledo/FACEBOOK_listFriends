package com.yendry.friendslist.ui.list;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by yendry on 4/21/2017.
 */

public class ListPresenter implements ListContract.Presenter
{


    @Override
    public ArrayList<String> getFriends(String jsondata) {

        JSONArray friendslist;
        ArrayList<String> friends = new ArrayList<String>();
        if (jsondata != null && jsondata.length()>0) {
            try {
                friendslist = new JSONArray(jsondata);
                for (int l=0; l < friendslist.length(); l++) {
                    friends.add(friendslist.getJSONObject(l).getString("name"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return friends;
    }
}
