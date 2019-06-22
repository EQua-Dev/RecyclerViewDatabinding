package com.example.recyclerviewdatabinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerviewdatabinding.databinding.ItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;
//TODO 44 start the RecyclerAdapter from the MainActivity.java
//TODO 27 the class extends RecyclerView.Adapter
//TODO 28 hit Alt+Enter on your keyboard and select 'implement needed methods'
//TODO 31 specify the generic type  of the RecyclerAdapter class by typing '<RecyclerAdapter.MyViewHolder>'
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    //TODO 34 create two private variables; 1st is a Context datatype named 'context', 2nd is a List datatype that contains object of the user class named 'users'
    private Context context;
    private List<User> users;

    //TODO 35 alt+insert a constructor for the two created variables
    public RecyclerAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    //TODO 36 return the size of the array list in the getItemCount method by replacing '0' with 'users.size'
    @NonNull
    @Override
    //TODO 32 change the class type from 'RecyclerView.ViewHolder' to 'MyViewHolder'
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //TODO 40 invoke inflater from viewGroup.getContext item_layout
        ItemLayoutBinding itemLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),R.layout.item_layout,viewGroup,false);

        //TODO 41 create an object of the viewholder class and pass the itemLayoutBinding, return the object name
                MyViewHolder myViewHolder = new MyViewHolder(itemLayoutBinding);

        return myViewHolder;
    }

    @Override
    //TODO 33 change the 1st view parameter to 'MyViewHolder'
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {

        //TODO 42 get the current user object by typing 'User [chosen variable name]= [list variable].get i
        User user = users.get(i);
        //TODO 43 set user to the dataBinding
        viewHolder.itemLayoutBinding.setUser(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    //TODO 29 create a public static ViewHolder class named 'MyViewHolder which extends ViewHolder
    public static class MyViewHolder extends RecyclerView.ViewHolder{
    //TODO 30 hit Alt+Enter and select 'create constructor matching super'

        //TODO 37 create  an object of your custom layout dataBinding class which is item_layout
        //type the object name 'ItemLayoutBinding' and name it *itemLayoutBinding
        ItemLayoutBinding itemLayoutBinding;
        //TODO 38 change the 1st parameter of the MyViewHolder method to the object name 'ItemLayoutBinding'

        public MyViewHolder(@NonNull ItemLayoutBinding itemView) {
            //TODO 39 call itemView.getRoot in the super and initialize the the itemLayoutBinding to itemView
            super(itemView.getRoot());
            itemLayoutBinding = itemView;
        }
    }
}
