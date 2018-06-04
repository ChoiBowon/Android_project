package com.example.choibowon.weather;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    TextView textview1;
    TextView textview2;

    Button button1; //날씨 보기
    Button start; //재생 버튼
    Button pause;
    Button restart;
    Document doc = null;
    LinearLayout layout = null;

    MediaPlayer mp;
    private int playbackPosition =0;
    //현재 시간 받아오기
    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("HH:mm:ss");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview1 = (TextView) findViewById(R.id.textView1);

        textview2 = (TextView) findViewById(R.id.textView2);


        button1 = (Button)findViewById(R.id.button1);
        start = (Button)findViewById(R.id.button2);
        pause = (Button)findViewById(R.id.button3);
        restart = (Button)findViewById(R.id.button4);


        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                mNow = System.currentTimeMillis();
                mDate = new Date(mNow);
                mFormat.format(mDate);

                textview1.setText("현재 시간 : " + mFormat.format(mDate));
                Parsing task = new Parsing();
                task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1159060500");
            }
        });

        pause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                playbackPosition = mp.getCurrentPosition();
                mp.pause();
            }
        });
        restart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               mp.start();
                mp.seekTo(playbackPosition);
            }
        });

    }



    //private inner class extending AsyncTask
    private class Parsing extends AsyncTask<String, Void, Document>{

        @Override
        protected Document doInBackground(String... urls) {
            URL url;
            try {
                url = new URL(urls[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder(); //XML문서 빌더 객체를 생성
                doc = db.parse(new InputSource(url.openStream())); //XML문서를 파싱한다.
                doc.getDocumentElement().normalize();

            } catch (Exception e) {
                //Toast.makeText(getBaseContext(), "Parsing Error", Toast.LENGTH_SHORT).show();
            }
            return doc;
        }

        @Override
        protected void onPostExecute(Document doc) {

            String s = "";
            //data태그가 있는 노드를 찾아서 리스트 형태로 만들어서 반환
            NodeList nodeList = doc.getElementsByTagName("data");
            //data 태그를 가지는 노드를 찾음, 계층적인 노드 구조를 반환

            //날씨 데이터를 추출
            int i = 0;
            s += "" + " 날씨 정보: ";

            Node node = nodeList.item(i); //data엘리먼트 노드
            Element fstElmnt = (Element) node;

            NodeList hourList  = fstElmnt.getElementsByTagName("hour");
            if(hourList.item(0).getChildNodes().item(0).getNodeValue().equals(mFormat.format(mDate))){

            }
            s += "시간 =" +hourList.item(0).getChildNodes().item(0).getNodeValue() + "\n";

            NodeList nameList  = fstElmnt.getElementsByTagName("temp");
            Element nameElement = (Element) nameList.item(0);
            nameList = nameElement.getChildNodes();
            s += "온도 = "+ ((Node) nameList.item(0)).getNodeValue() +" ,";


            final NodeList websiteList = fstElmnt.getElementsByTagName("wfKor");
            //<wfKor>맑음</wfKor> =====> <wfKor> 태그의 첫번째 자식노드는 TextNode 이고 TextNode의 값은 맑음
            s += "날씨 = "+  websiteList.item(0).getChildNodes().item(0).getNodeValue() +"\n";

            start.setOnClickListener(new View.OnClickListener(){
                @Override
                public  void onClick(View v){
                    if(websiteList.item(0).getChildNodes().item(0).getNodeValue().equals("구름많음")){
                        mp = MediaPlayer.create(getApplicationContext(), R.raw.thestatement);
                    }else if(websiteList.item(0).getChildNodes().item(0).getNodeValue().equals("구름조금")){
                        mp = MediaPlayer.create(getApplicationContext(), R.raw.queenzthelyricisthiphopfttheloniousmp3);
                    }else if(websiteList.item(0).getChildNodes().item(0).getNodeValue().equals("맑음")){
                        mp = MediaPlayer.create(getApplicationContext(), R.raw.themadpixprojectmoments);
                    }else if(websiteList.item(0).getChildNodes().item(0).getNodeValue().equals("흐림")){
                        mp = MediaPlayer.create(getApplicationContext(), R.raw.ralphcastelligoodmorning);
                    }else if(websiteList.item(0).getChildNodes().item(0).getNodeValue().equals("비")){
                        mp = MediaPlayer.create(getApplicationContext(), R.raw.duoteslaruniversalfunk);
                    }else if(websiteList.item(0).getChildNodes().item(0).getNodeValue().equals("눈/비")){
                        mp = MediaPlayer.create(getApplicationContext(), R.raw.robingreyhymnforher);
                    }else{
                        mp = MediaPlayer.create(getApplicationContext(), R.raw.melanieungarcrazyglue);
                    }

                    mp.start();

                }
            });

            




            textview2.setText(s);

            super.onPostExecute(doc);
        }


    }
}
