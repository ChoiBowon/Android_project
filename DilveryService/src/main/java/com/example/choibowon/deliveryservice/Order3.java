package com.example.choibowon.deliveryservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by choibowon on 2017. 9. 29..
 */

public class Order3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order3);

        final TextView menuname3 = (TextView)findViewById(R.id.menuName3);
        final EditText editText3 = (EditText)findViewById(R.id.edittext3) ;

        final Button okbtn = (Button)findViewById(R.id.ok3);
        final TextView textView3 = (TextView)findViewById(R.id.textview3);




        okbtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v){

                String string = editText3.getText().toString();
                int i = Integer.parseInt(string)*12000;

                textView3.setText(Integer.toString(i));

            }

        });


        Button orderbtn = (Button)findViewById(R.id.orderbutton3);
        orderbtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                String menustr = menuname3.getText().toString();
                String countstr = editText3.getText().toString();
                int allprice = Integer.parseInt(countstr)*12000;
                String pricestr = Integer.toString(allprice);
                Intent intent = new Intent(getApplicationContext(),delivery.class);
                intent.setAction("kr.co.hta.Delivery");
                intent.putExtra("menu" ,menustr);
                intent.putExtra("count", countstr);
                intent.putExtra("price", pricestr);
                startActivity(intent);

            }

        });

    }




}
