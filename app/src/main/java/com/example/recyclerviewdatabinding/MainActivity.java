package com.example.recyclerviewdatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.recyclerviewdatabinding.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO 8 create a new java class named User
//TODO 26 create the adapter for the recyclerView, create a new java class and name it *RecyclerAdapter
public class MainActivity extends AppCompatActivity {
//TODO 22 create a private Binding method and name it *mainBinding
    //Method type must be the name of the activty_main followed by 'Binding', all camelcased

    private ActivityMainBinding mainBinding;
     //TODO 51 create a private RecyclerAdapter and name it *adapter
    private RecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO 23 comment out or delete the 'setContentView(R.layout.activity_main
        //setContentView(R.layout.activity_main);

        //TODO 24 assign the mainBinding attribute to 'DataBindingUtil.setContentView(this,R.layout.activity_main'
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        //TODO 25 initialize the recyclerView and invoke the LayoutManager
        //mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this))
        mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //mainBinding.recyclerView.setHasFixedSized(true)
        mainBinding.recyclerView.setHasFixedSize(true);

        //TODO 52 initialize the adapter as a new RecyclerAdapter with two parameters; this, prepareUser
        adapter = new RecyclerAdapter(this,prepareUser());
        //TODO 53 set adapter dor the mainBinding.recyclerView and pass in adapter
        mainBinding.recyclerView.setAdapter(adapter);
    }

    //TODO 45 create a 'prepareUser' method of 'List' class type that passes the 'User' java class
    private List<User> prepareUser(){

        //TODO 46 get the array list saved in the strings.xml
        List<String> names = Arrays.asList(getResources().getStringArray(R.array.names));
        List<String> email = Arrays.asList(getResources().getStringArray(R.array.emails));
        //TODO 47 create an array to refer the imageId to the image names in the drawable folder
        int[] imageId = {R.drawable.abiodun,R.drawable.boborish,R.drawable.chinenye,R.drawable.equa,
                R.drawable.jane,R.drawable.luomy,R.drawable.oluoma,R.drawable.richard,R.drawable.uzor};
        //TODO 48 create a list called names make it an array list and create a variable 'count' initialized to 0
        List<User> Names = new ArrayList<>();
        int count = 0;

        //TODO 49 create a for loop such that for every name there is an assigned email and image, incrementing each assignment by one
        for(String name : names){

            Names.add((new User(name,email.get(count),imageId[count])));
            count++;
        }
        //TODO 50 return Names
        return Names;
    }

}
