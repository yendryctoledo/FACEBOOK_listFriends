package com.yendry.friendslist.di.modules;

import com.yendry.friendslist.ui.list.ListContract;
import com.yendry.friendslist.ui.list.ListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yendry on 4/23/2017.
 */
@Module
public class ListModule {
    @Provides
    public ListContract.Presenter providePresenter(){
        return new ListPresenter();
    }
}
