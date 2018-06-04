package com.example.choibowon.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.*;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edittext1 = (EditText)findViewById(R.id.editText1);
        edittext1.setText("숫자를 입력하시오");

        String strtext1 = edittext1.getText().toString();
        final int num1 = Integer.parseInt(strtext1);


        EditText edittext2 = (EditText)findViewById(R.id.editText2);
        edittext2.setText("숫자를 입력하시오");

        String strtext2 = edittext2.getText().toString();
        final int num2 = Integer.parseInt(strtext2);


        final EditText edittext3 = (EditText)findViewById(R.id.editText3);
        edittext3.setText("숫자를 입력하시오");






        Button b1 = (Button)findViewById(R.id.button1);
        b1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                int result = 0;
                result = num1+num2;
                edittext3.setText(Integer.toString(result));



            }
        });

        Button b2 = (Button)findViewById(R.id.button2);
        b2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                int result = 0;
                result = num1-num2;
                edittext3.setText(Integer.toString(result));


            }
        });

        Button b3 = (Button)findViewById(R.id.button3);
        b3.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                int result = 0;
                result = num1*num2;
                edittext3.setText(Integer.toString(result));


            }
        });

        Button b4 = (Button)findViewById(R.id.button4);
        b4.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                int result = 0;
                result = num1/num2;
                edittext3.setText(Integer.toString(result));

            }
        });

    }
}
