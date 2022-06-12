package com.example.news_app13135;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class MainAdapter extends BaseAdapter {

    News_API news_api;
    ArrayList<String> arrayList =  new ArrayList<>();
    String[] title;
    String[] str;
    String[] URL;
    String[] desc;
    //    String[] desc;
    Animation animation;

    public  MainAdapter(News_API news_api, String[] desc, String[] title, String[] URL, ArrayList<String> arrayList){
//        super(news_api, R.layout.new_item_layout);
        this.news_api = news_api;
        this.title=title;
        this.desc=desc;
        this.URL=URL;
        arrayList=arrayList;
        str    = new String[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            str[i] = arrayList.get(i);
        }
//        Log.d("MainAdapter: ", str[0]);
    }


    public static int getRandom(int max)
    {
        return (int) (Math.random()*max);
    }






    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(news_api).inflate(R.layout.new_item_layout,viewGroup,false);
        animation= AnimationUtils.loadAnimation(news_api,R.anim.animation1);

        TextView textView,textView1,textView2;
        LinearLayout ll_bg;
        ll_bg=view.findViewById(R.id.ll_bg);
        textView=view.findViewById(R.id.text_view);
        textView1=view.findViewById(R.id.text_view_url);
        textView2=view.findViewById(R.id.text_view_ID);

        int number=getRandom(8);
        if(number==1)
        {
            ll_bg.setBackground(ContextCompat.getDrawable(news_api,R.drawable.gradient_1));
        }
        else if(number==2)
        {
            ll_bg.setBackground(ContextCompat.getDrawable(news_api,R.drawable.gradient_2));
        }
        else if(number==3)
        {
            ll_bg.setBackground(ContextCompat.getDrawable(news_api,R.drawable.gradient_3));
        }
        else if(number==4)
        {
            ll_bg.setBackground(ContextCompat.getDrawable(news_api,R.drawable.gradient_4));
        }
        else if(number==5)
        {
            ll_bg.setBackground(ContextCompat.getDrawable(news_api,R.drawable.gradient_5));
        }
        else if(number==6)
        {
            ll_bg.setBackground(ContextCompat.getDrawable(news_api,R.drawable.gradient_6));
        }
        else if(number==7)
        {
            ll_bg.setBackground(ContextCompat.getDrawable(news_api,R.drawable.gradient_7));
        }
        else if(number==8)
        {
            ll_bg.setBackground(ContextCompat.getDrawable(news_api,R.drawable.gradient_8));
        }
        else
        {
            ll_bg.setBackground(ContextCompat.getDrawable(news_api,R.drawable.snow_bg));
        }


//        textView.setText(title[i]);
//        Log.d("DATA", title[i]);
//        textView.setAnimation(animation);

            textView.setText(title[i]);
            textView1.setText(desc[i]);
            textView2.setText(URL[i]);
            Log.d("DATA", title[i]);



        return view;
    }
}
