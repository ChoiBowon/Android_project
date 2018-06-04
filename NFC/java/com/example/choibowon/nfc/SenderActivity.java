package com.example.choibowon.nfc;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TextView;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by choibowon on 2017. 12. 1..
 */
public class SenderActivity extends Activity implements NfcAdapter.CreateNdefMessageCallback,NfcAdapter.OnNdefPushCompleteCallback{

    NfcAdapter mNfcAdapter = null;
    private NdefMessage msgs[];
    private TextView tvTest;
    private MyMessage myMsg = null;
    private ArrayList<String> myArrayListBody;
    private ArrayList<String> myArrayListMId;
    private ArrayList<String> myArrayListCId;
    private ArrayList<String> myArrayListTId;
    private ArrayList<String> myArrayListAddress;
    private ArrayList<String> myArrayListTime;



    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
        tvTest = (TextView)findViewById(R.id.tv_test);

        if (ActivityCompat.checkSelfPermission((SenderActivity.this), Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((SenderActivity.this), new String[]{Manifest.permission.READ_SMS}, 10);
            Log.d("MessageChecker", "if");
        } else {
            Log.d("MessageChecker", "else");

            readSMSMessage();
        }



        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if(mNfcAdapter!=null){
            tvTest.setText("Tap to another NFC device. And touch screen");
        }else{
            tvTest.setText("This phone is not NFC enable");
        }

        // NDEF 메시지 생성 & 전송을 위한 콜백 함수 설정
        mNfcAdapter.setNdefPushMessageCallback(this, this);
        // NDEF 메시지 전송 완료 이벤트 콜백 함수 설정
        mNfcAdapter.setOnNdefPushCompleteCallback(this, this);



    }

    //sms 가져오는 코드
    public int readSMSMessage() {



        myArrayListBody = new ArrayList();
        myArrayListAddress = new ArrayList();
        myArrayListCId= new ArrayList();
        myArrayListMId= new ArrayList();
        myArrayListTId= new ArrayList();
        myArrayListTime = new ArrayList();

        if(ContextCompat.checkSelfPermission(getBaseContext(), "android.permission.READ_SMS") == PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(SenderActivity.this, new String[]{"android.permission.READ_SMS"}, REQUEST_CODE_ASK_PERMISSIONS);
        }
        Uri allMessage = Uri.parse("content://sms");
        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(allMessage,
                new String[]{"_id", "thread_id", "address", "person", "date", "body"},
                null, null,
                "date DESC");

        while (c.moveToNext()) {
            myMsg = new MyMessage(); // 따로 저는 클래스를 만들어서 담아오도록 했습니다.

            long messageId = c.getLong(0);
            myMsg.setMessageId(String.valueOf(messageId));

            long threadId = c.getLong(1);
            myMsg.setThreadId(String.valueOf(threadId));

            String address = c.getString(2);
            myMsg.setAddress(address);

            long contactId = c.getLong(3);
            myMsg.setContactId(String.valueOf(contactId));

            String contactId_string = String.valueOf(contactId);
            myMsg.setContactId_string(contactId_string);

            long timestamp = c.getLong(4);
            myMsg.setTimestamp(String.valueOf(timestamp));

            String body = c.getString(5);
            myMsg.setBody(body);

            myArrayListBody.add(myMsg.getBody());
            myArrayListTId.add(myMsg.getThreadId());
            myArrayListMId.add(myMsg.getMessageId());
            myArrayListCId.add(myMsg.getContactId());
            myArrayListAddress.add(myMsg.getAddress());

            String longV = myMsg.getTimestamp();
            long millisecond = Long.parseLong(longV);
            String dateString = DateFormat.format("yyyy년 MM월 dd일 hh시 mm분", new Date(millisecond)).toString();


            myArrayListTime.add(dateString);


        }

        for(int i=0; i<myArrayListBody.size();i++){
            Log.d("MessageChecker", "Contact Id = "+myArrayListCId.get(i));
            Log.d("MessageChecker", "Thread Id = "+myArrayListTId.get(i));
            Log.d("MessageChecker", "Message Id = "+myArrayListMId.get(i));
            Log.d("MessageChecker", "Address = "+myArrayListAddress.get(i));
            Log.d("MessageChecker", "Body = "+myArrayListBody.get(i));
            Log.d("MessageChecker", "Time = "+myArrayListTime.get(i));
            Log.d("MessageChecker","---------------------------------------");
        }
        return 0;
    }

    public class MyMessage {
        String messageId;
        String threadId;
        String address; //휴대폰번호
        String contactId;
        String contactId_string;
        String timestamp; //시간
        String body; //문자내용

        public MyMessage() {
        }

        public String getMessageId() {
            return messageId;
        }

        public void setMessageId(String messageId) {
            this.messageId = messageId;
        }

        public String getThreadId() {
            return threadId;
        }

        public void setThreadId(String threadId) {
            this.threadId = threadId;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getContactId() {
            return contactId;
        }

        public void setContactId(String contactId) {
            this.contactId = contactId;
        }

        public String getContactId_string() {
            return contactId_string;
        }

        public void setContactId_string(String contactId_string) {
            this.contactId_string = contactId_string;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }



    // NDEF 메시지 생성 이벤트 함수
    @Override
    public NdefMessage createNdefMessage(NfcEvent event) {
        // 여러개의 NDEF 레코드를 모아서 하나의 NDEF 메시지를 생성
        NdefMessage message = new NdefMessage( new NdefRecord[] {

                createTextRecord("\n날짜: "+myArrayListTime.get(0)+"\n번호: "+myArrayListAddress.get(0)+"\n내용:\n"+myArrayListBody.get(0), Locale.KOREAN),
                createTextRecord("\n날짜: "+myArrayListTime.get(1)+"\n번호: "+myArrayListAddress.get(1)+"\n내용:\n"+myArrayListBody.get(1),Locale.KOREAN),
                createTextRecord("\n날짜: "+myArrayListTime.get(2)+"\n번호: "+myArrayListAddress.get(2)+"\n내용:\n"+myArrayListBody.get(2),Locale.KOREAN),
                createTextRecord("\n날짜: "+myArrayListTime.get(3)+"\n번호: "+myArrayListAddress.get(3)+"\n내용:\n"+myArrayListBody.get(3),Locale.KOREAN),
                createTextRecord("\n날짜: "+myArrayListTime.get(4)+"\n번호: "+myArrayListAddress.get(4)+"\n내용:\n"+myArrayListBody.get(4),Locale.KOREAN),
                createTextRecord("\n날짜: "+myArrayListTime.get(5)+"\n번호: "+myArrayListAddress.get(5)+"\n내용:\n"+myArrayListBody.get(5),Locale.KOREAN),
                createTextRecord("\n날짜: "+myArrayListTime.get(6)+"\n번호: "+myArrayListAddress.get(6)+"\n내용:\n"+myArrayListBody.get(6),Locale.KOREAN),
                createTextRecord("\n날짜: "+myArrayListTime.get(7)+"\n번호: "+myArrayListAddress.get(7)+"\n내용:\n"+myArrayListBody.get(7),Locale.KOREAN),
                createTextRecord("\n날짜: "+myArrayListTime.get(8)+"\n번호: "+myArrayListAddress.get(8)+"\n내용:\n"+myArrayListBody.get(8),Locale.KOREAN),
                createTextRecord("\n날짜: "+myArrayListTime.get(9)+"\n번호: "+myArrayListAddress.get(9)+"\n내용:\n"+myArrayListBody.get(9),Locale.KOREAN),
                createTextRecord("\n날짜: "+myArrayListTime.get(10)+"\n번호: "+myArrayListAddress.get(10)+"\n내용:\n"+myArrayListBody.get(10),Locale.KOREAN),
        });
        return message;
    }

    // 텍스트 형식의 레코드를 생성
    public NdefRecord createTextRecord(String text, Locale locale) {
        // 텍스트 데이터를 인코딩해서 byte 배열로 변환
        byte[] data = byteEncoding(text, locale);
        return new NdefRecord(NdefRecord.TNF_WELL_KNOWN, NdefRecord.RTD_TEXT, new byte[0], data);
    }

    // 텍스트 데이터를 인코딩해서 byte 배열로 변환
    public byte[] byteEncoding(String text, Locale locale) {
        // 언어 지정 코드 생성
        byte[] langBytes = locale.getLanguage().getBytes(Charset.forName("US-ASCII"));
        // 인코딩 형식 생성
        Charset utfEncoding = Charset.forName("UTF-8");
        // 텍스트를 byte 배열로 변환
        byte[] textBytes = text.getBytes(utfEncoding);

        // 전송할 버퍼 생성
        byte[] data = new byte[1 + langBytes.length + textBytes.length];
        data[0] = (byte)langBytes.length;
        // 버퍼에 언어 코드 저장
        System.arraycopy(langBytes, 0, data, 1, langBytes.length);
        // 버퍼에 데이터 저장
        System.arraycopy(textBytes, 0, data, 1 + langBytes.length, textBytes.length);
        return data;
    }

    // URI 형식의 레코드를 생성
    public NdefRecord createUriRecord(String url) {
        // URI 경로를 byte 배열로 변환할 때 US-ACSII 형식으로 지정
        byte[] uriField = url.getBytes(Charset.forName("US-ASCII"));
        // URL 경로를 의미하는 1 을 첫번째 byte 에 추가
        byte[] payload = new byte[uriField.length + 1];
        payload[0] = 0x01;
        System.arraycopy(uriField, 0, payload, 1, uriField.length);
        // NDEF 레코드를 생성해서 반환
        return new NdefRecord(NdefRecord.TNF_WELL_KNOWN, NdefRecord.RTD_URI, new byte[0], payload);
    }

    // NDEF 메시지 전송 완료 이벤트 함수
    @Override
    public void onNdefPushComplete(NfcEvent event) {
        // 핸들러에 메시지를 전달한다
        mHandler.obtainMessage(1).sendToTarget();
    }

    // NDEF 메시지 전송이 완료되면 TextView 에 결과를 표시한다
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    tvTest.setText("메시지 전송이 완료되었습니다.");
                    break;
            }
        }
    };

}





