package com.yendry.friendslist.ui.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.yendry.friendslist.R;
import com.yendry.friendslist.di.component.DaggerListComponent;
import com.yendry.friendslist.di.modules.ListModule;

import javax.inject.Inject;


public class FriendsList extends AppCompatActivity {
    TextView textView;
    Adapter adapter;
    RecyclerView rv;
    @Inject
    ListContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);

        DaggerListComponent.builder()
                .listModule(new ListModule())
                .build()
                .inject(this);

        //ListPresenter presenter = new ListPresenter();
        rv = (RecyclerView) findViewById(R.id.rv);
        textView = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        String jsondata = intent.getStringExtra("jsondata");
        adapter = new Adapter(presenter.getFriends(jsondata));
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(adapter);
    }
}
