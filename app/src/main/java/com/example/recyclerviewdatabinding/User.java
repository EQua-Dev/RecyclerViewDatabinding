package com.example.recyclerviewdatabinding;

import android.databinding.BindingAdapter;
import android.support.v4.content.ContextCompat;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;

public class User {
    //TODO 9 create two string variables name and email and one int variable of imageId

    public String name,email;
    public int imageId;

    //TODO 10 press alt+insert on your keyboard and select constructor

    public User(String name, String email, int imageId){
        this.name = name;
        this.email = email;
        this.imageId = imageId;
    }
    //TODO 11 create a new layout named item_layout and make the root layout to be <layout>

    //TODO 56 create an annotation '@BindingAdapter' and specify a custom xml attributr names 'android:*imageUrl'
    @BindingAdapter("android:imageUrl")
    //TODO 54 create a public staic void method named *loadImage and pass in two parameters; View view, int imageId
    public static void loadImage(View view, int imageId){

        //TODO 55 load images from the drawable folder to the imageView
        CircleImageView circleImageView = (CircleImageView) view;
        circleImageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(),imageId));

    }
}



