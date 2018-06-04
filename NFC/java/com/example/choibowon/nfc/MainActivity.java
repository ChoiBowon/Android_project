package com.example.choibowon.nfc;


import android.app.Activity;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.nfc.tech.Ndef;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.charset.Charset;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private Button btScanner, btSender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btScanner = (Button) findViewById(R.id.bt_scanner);
        btSender = (Button) findViewById(R.id.bt_sender);
        btScanner.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intentScanner = new Intent(getApplicationContext(), ScannerActivity.class);
                startActivity(intentScanner);
            }
        });

        btSender.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intentSender = new Intent(getApplicationContext(), SenderActivity.class);
                startActivity(intentSender);
            }
        });


    }


}