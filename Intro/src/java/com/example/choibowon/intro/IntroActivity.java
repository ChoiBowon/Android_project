package com.example.choibowon.intro;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.Window;
import android.widget.ImageView;

/**
 * Created by choibowon on 2017. 11. 17..
 */

public class IntroActivity extends Activity{

    Handler h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_intro);

        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.world2);
        setContentView(img);
        img.setBackgroundColor(Color.parseColor("#2F4F4F"));

        h = new Handler();
        h.postDelayed(run, 3000);
    }

    Runnable run = new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(IntroActivity.this, MainActivity.class);
            startActivity(i);
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };

    public void onBackPressed(){
        super.onBackPressed();
        h.removeCallbacks(run);
    }
}
