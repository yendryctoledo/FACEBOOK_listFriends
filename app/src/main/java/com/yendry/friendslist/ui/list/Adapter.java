package com.yendry.friendslist.ui.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yendry.friendslist.R;

import java.util.ArrayList;


/**
 * Created by yendry on 4/21/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyVH> {

    private ArrayList<String> list = new ArrayList<>();

    public Adapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new MyVH(view);
    }

    @Override
    public void onBindViewHolder(MyVH holder, int position) {
        holder.name.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView name;
        public MyVH(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.txt_member);
        }
    }
}
