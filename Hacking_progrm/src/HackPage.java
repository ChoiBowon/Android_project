package com.example.choibowon.hackingprogram;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;



public class HackPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hack_page);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);

        ImageView imageView = (ImageView)findViewById(R.id.imageview1);
        imageView.startAnimation(animation);

        ImageView imageView2 = (ImageView)findViewById(R.id.imageview2);
        imageView2.startAnimation(animation);

        TextView text1 = (TextView)findViewById(R.id.textView1);
        text1.startAnimation(animation2);


        TextView text2 = (TextView)findViewById(R.id.textView2);
        text2.startAnimation(animation2);

        final AlertDialog.Builder alert1 = new AlertDialog.Builder(this);
        final AlertDialog.Builder alert2 = new AlertDialog.Builder(this);
        final AlertDialog.Builder alert3 = new AlertDialog.Builder(this);
        final AlertDialog.Builder alert4 = new AlertDialog.Builder(this);
        final AlertDialog.Builder alert5 = new AlertDialog.Builder(this);
        final AlertDialog.Builder alert6 = new AlertDialog.Builder(this);
        final AlertDialog.Builder alert7 = new AlertDialog.Builder(this);
        final AlertDialog.Builder alert8 = new AlertDialog.Builder(this);
        final AlertDialog.Builder alert9 = new AlertDialog.Builder(this);
        final AlertDialog.Builder alert10 = new AlertDialog.Builder(this);

        Handler mhandler = new Handler();
        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                alert1.setTitle("시스템 경고!");
                alert1.setIcon(R.drawable.warning);
                alert1.setMessage("해킹되었습니다!!")
                        .setCancelable(false);
                alert1.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int id){
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog = alert1.create();
                alertDialog.show();

                alert2.setTitle("시스템 경고!");
                alert2.setIcon(R.drawable.warning);
                alert2.setMessage("해킹되었습니다!!")
                        .setCancelable(false);
                alert2.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int id){
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog2 = alert2.create();
                alertDialog2.show();

                alert3.setTitle("시스템 경고!");
                alert3.setIcon(R.drawable.warning);
                alert3.setMessage("해킹되었습니다!!")
                        .setCancelable(false);
                alert3.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int id){
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog3 = alert3.create();
                alertDialog3.show();

                alert4.setTitle("시스템 경고!");
                alert4.setIcon(R.drawable.warning);
                alert4.setMessage("해킹되었습니다!!")
                        .setCancelable(false);
                alert4.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int id){
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog4 = alert4.create();
                alertDialog4.show();

                alert5.setTitle("시스템 경고!");
                alert5.setIcon(R.drawable.warning);
                alert5.setMessage("해킹되었습니다!!")
                        .setCancelable(false);
                alert5.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int id){
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog5 = alert5.create();
                alertDialog5.show();

                alert6.setTitle("시스템 경고!");
                alert6.setIcon(R.drawable.warning);
                alert6.setMessage("해킹되었습니다!!")
                        .setCancelable(false);
                alert6.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int id){
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog6 = alert6.create();
                alertDialog6.show();

                alert7.setTitle("시스템 경고!");
                alert7.setIcon(R.drawable.warning);
                alert7.setMessage("해킹되었습니다!!")
                        .setCancelable(false);
                alert7.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int id){
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog7 = alert7.create();
                alertDialog7.show();

                alert8.setTitle("시스템 경고!");
                alert8.setIcon(R.drawable.warning);
                alert8.setMessage("해킹되었습니다!!")
                        .setCancelable(false);
                alert8.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int id){
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog8 = alert8.create();
                alertDialog8.show();

                alert9.setTitle("시스템 경고!");
                alert9.setIcon(R.drawable.warning);
                alert9.setMessage("해킹되었습니다!!")
                        .setCancelable(false);
                alert9.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int id){
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog9 = alert9.create();
                alertDialog9.show();

                alert10.setTitle("시스템 경고!");
                alert10.setIcon(R.drawable.warning);
                alert10.setMessage("해킹되었습니다!!")
                        .setCancelable(false);
                alert10.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int id){
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialog10 = alert10.create();
                alertDialog10.show();

            }

        }, 5000);




    }




}