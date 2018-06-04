package com.example.choibowon.hackingprogram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameText = (EditText) findViewById(R.id.name);

        final EditText numberText = (EditText) findViewById(R.id.number);


        final Button b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                    Intent intent = new Intent(getApplicationContext(),HackPage.class);
                    startActivity(intent);

            }

        });

    }
}
