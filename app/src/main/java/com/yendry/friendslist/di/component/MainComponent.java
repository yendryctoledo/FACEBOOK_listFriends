package com.yendry.friendslist.di.component;

import com.yendry.friendslist.di.modules.MainModule;
import com.yendry.friendslist.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by yendry on 4/23/2017.
 */
@Component(modules = MainModule.class)
public interface MainComponent {
void inject(MainActivity mainActivity);
}
