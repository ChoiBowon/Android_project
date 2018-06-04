package com.example.choibowon.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.support.v7.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;


public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);


        TextView text1 = (TextView)findViewById(R.id.text);
        text1.startAnimation(animation);

        LinearLayout layout = (LinearLayout) findViewById(R.id.linear);
        //setContentView(layout);


        layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });






    }




}