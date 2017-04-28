package com.yendry.friendslist.ui.main;

import com.facebook.AccessToken;
import com.yendry.friendslist.BasePresenter;
import com.yendry.friendslist.BaseView;

import org.json.JSONArray;

/**
 * Created by yendry on 4/21/2017.
 */

public interface MainContract {
    interface View extends BaseView<Presenter>{
        void showData(String str);
    }
    interface Presenter extends BasePresenter{
         void getFriends(AccessToken accessToken);
    }
}
