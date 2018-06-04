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

public class Order2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order2);

        final TextView menuname2 = (TextView)findViewById(R.id.menuName2);
        final EditText editText2 = (EditText)findViewById(R.id.edittext2) ;

        final Button okbtn = (Button)findViewById(R.id.ok2);
        final TextView textView2 = (TextView)findViewById(R.id.textview2);









        okbtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v){

                String string = editText2.getText().toString();
                int i = Integer.parseInt(string)*10000;

                textView2.setText(Integer.toString(i));

            }

        });



        Button orderbtn = (Button)findViewById(R.id.orderbutton2);
        orderbtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                String menustr = menuname2.getText().toString();
                String countstr = editText2.getText().toString();
                int allprice = Integer.parseInt(countstr)*10000;
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
