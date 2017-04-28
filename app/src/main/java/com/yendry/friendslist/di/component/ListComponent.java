package com.yendry.friendslist.di.component;

import com.yendry.friendslist.di.modules.ListModule;
import com.yendry.friendslist.ui.list.FriendsList;

import dagger.Component;

/**
 * Created by yendry on 4/23/2017.
 */
@Component(modules = ListModule.class)
public interface ListComponent {
    void inject(FriendsList friendsList);
}
