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

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);

        final TextView menuname1 = (TextView)findViewById(R.id.menuName1);
        final EditText editText1 = (EditText)findViewById(R.id.edittext1) ;

        final Button okbtn = (Button)findViewById(R.id.ok);
        final TextView textView1 = (TextView)findViewById(R.id.textview1);


        okbtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v){

                String string = editText1.getText().toString();
                 int i = Integer.parseInt(string)*19000;

                textView1.setText(Integer.toString(i));

            }

        });


        Button orderbtn = (Button)findViewById(R.id.orderbutton);
        orderbtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                String menustr = menuname1.getText().toString();
                String countstr = editText1.getText().toString();
                int allprice = Integer.parseInt(countstr)*19000;
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
