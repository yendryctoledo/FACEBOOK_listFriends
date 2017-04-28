package com.yendry.friendslist.di.modules;

/**
 * Created by yendry on 4/23/2017.
 */

import com.yendry.friendslist.ui.main.MainContract;
import com.yendry.friendslist.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;


@Module
public class MainModule {
    MainContract.View view;

    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @Provides
    public MainContract.Presenter providePresenter(){
        return new MainPresenter(view);
    }

}
