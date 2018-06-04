package com.example.choibowon.deliveryservice;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ListView;

import java.util.ArrayList;


public class Main2Activity extends AppCompatActivity {

    private ListView mListView ;
    private MyAdapter mMyAdapter;
    private ArrayList<MyItem> mItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mListView = (ListView) findViewById(R.id.listview);
        mItems = new ArrayList<MyItem>();

        dataSetting();

    }

    private void dataSetting(){

        mMyAdapter = new MyAdapter(Main2Activity.this);



        for(int i=0; i<3; i++){
            if(i == 0){
                mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.first), "맛있는 구절판" , "");
            }else if(i ==1){
                mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.third), "떡튀김", "");
            }else if(i ==2){
                mMyAdapter.addItem(ContextCompat.getDrawable(getApplicationContext(), R.drawable.two), "슴슴한 낙지덮밥", "");
            }


        }



        mListView.setAdapter(mMyAdapter);







    }









}