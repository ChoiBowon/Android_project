package com.example.choibowon.deliveryservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by choibowon on 2017. 9. 29..
 */

public class delivery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery);

        Intent intent = getIntent();

        if(intent.getAction().equals("kr.co.hta.Delivery")){

            String menu = (String)intent.getExtras().get("menu");
            TextView menutext = (TextView)findViewById(R.id.menu);
            menutext.setText(menu);

            String count = (String)intent.getExtras().get("count");
            TextView counttext = (TextView)findViewById(R.id.count);
            counttext.setText(count);

            String price = (String)intent.getExtras().get("price");
            TextView pricetext = (TextView)findViewById(R.id.price);
            pricetext.setText(price);




        }





    }


}
