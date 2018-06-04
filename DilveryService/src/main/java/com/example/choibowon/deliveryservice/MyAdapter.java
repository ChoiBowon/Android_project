package com.example.choibowon.deliveryservice;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.app.Activity;

/**
 * Created by choibowon on 2017. 9. 29..
 */

public class MyAdapter extends BaseAdapter {



    private ArrayList <MyItem> mItems = new ArrayList<>();
    Context context;


    public MyAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount(){
        return mItems.size();
    }

    @Override
    public MyItem getItem(int position){
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent){



        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_custom,parent,false);
        }

        ImageView img = convertView.findViewById(R.id.listimageview);
        final TextView text_name = convertView.findViewById(R.id.listtextview);

        Button b1 = convertView.findViewById(R.id.b1);
        Button b2 = convertView.findViewById(R.id.b2);
        b1.setTag(position);
        b2.setTag(position);


        final MyItem myItem = getItem(position);

        img.setImageDrawable(myItem.getIcon());
        text_name.setText(myItem.getName());


        //이벤트 리스너 여기 쓰기



       b1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){

                int position = (Integer) view.getTag();

                if(position == 0 ){
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+82)1111-2222"));
                    context.startActivity(intent);
                }else if(position == 1){
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+82)1111-3333"));
                    context.startActivity(intent);
                }else if(position ==2){
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+82)1111-4444"));
                    context.startActivity(intent);
                }



            }

        });

        b2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                int position1 = (Integer) view.getTag();

                if(position1 == 0 ){
                    Intent intent = new Intent(context, OrderActivity.class);
                    context.startActivity(intent);
                }else if(position1 == 1){
                    Intent intent = new Intent(context, Order2.class);
                    context.startActivity(intent);
                }else if(position1 ==2){
                    Intent intent = new Intent(context, Order3.class);
                    context.startActivity(intent);
                }

            }

        });



        return convertView;
    }

    public void addItem(Drawable img, String name, String contents){
        MyItem mItem = new MyItem();

        mItem.setIcon(img);
        mItem.setName(name);
        mItem.setContents(contents);

        mItems.add(mItem);
    }




}
