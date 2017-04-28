package com.yendry.friendslist.ui.list;


import com.yendry.friendslist.BasePresenter;
import com.yendry.friendslist.BaseView;

import java.util.ArrayList;

/**
 * Created by yendry on 4/21/2017.
 */

public interface ListContract {
    interface Presenter extends BasePresenter {
        ArrayList<String> getFriends(String jsondata);
    }
    interface View extends BaseView<Presenter>{

    }
}
