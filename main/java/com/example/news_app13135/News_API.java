package com.example.news_app13135;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;


import com.google.android.gms.common.util.ArrayUtils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class News_API extends AppCompatActivity {
    ListView listView;
    Animation animation;
    String title[]={"as PML-N tries to","HULK","CAPTIAN_AMERICA","ECP slaps Rs50,000 fine on Gandapur","ANT MAN","BLACK WIDOW","HULK-2","HULK","CAPTIAN_AMERICA","THOR","ANT MAN","BLACK WIDOW","HULK-2","HULK","CAPTIAN_AMERICA","THOR","ANT MAN","BLACK WIDOW","HULK-2","HULK","CAPTIAN_AMERICA","THOR","ANT MAN","BLACK WIDOW","HULK-2"};
    String desc[]={"The only contribution [by the PML-N] was the start of the track's construction,\\u201d the minister said following","The commission also warned Gandapur to be aware of violating the election code in the future otherwise it held the right to suspend his membership. On Thursday, the commission directed the federal minister to submit the fine in the national treasury by Friday (today). He had said that if the rival candidate won, he won\\u2019t be allowed to enter the ministry of local governmen","CAPTIAN_AMERICA","THOR","ANT MAN","BLACK WIDOW","HULK-2","HULK","CAPTIAN_AMERICA","THOR","ANT MAN","BLACK WIDOW","HULK-2","HULK","CAPTIAN_AMERICA","THOR","ANT MAN","BLACK WIDOW","HULK-2","HULK","CAPTIAN_AMERICA","THOR","ANT MAN","BLACK WIDOW","HULK-2"};
    String URL[]={"https://reqres.in/api/products/3","The commission also warned Gandapur to be aware of violating the election code in the future otherwise it held the right to suspend his membership. On Thursday, the commission directed the federal minister to submit the fine in the national treasury by Friday (today). He had said that if the rival candidate won, he won\\u2019t be allowed to enter the ministry of local governmen","CAPTIAN_AMERICA","THOR","ANT MAN","BLACK WIDOW","HULK-2","HULK","CAPTIAN_AMERICA","THOR","ANT MAN","BLACK WIDOW","HULK-2","HULK","CAPTIAN_AMERICA","THOR","ANT MAN","BLACK WIDOW","HULK-2","HULK","CAPTIAN_AMERICA","THOR","ANT MAN","BLACK WIDOW","HULK-2"};
    String[] title_2;
    String[] arr;

    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String>arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       getSupportActionBar().hide();
       setContentView(R.layout.activity_news_api);
/////okhttps//////
        OkHttpClient client = new OkHttpClient();
        String url = "https://alasartothepoint.alasartechnologies.com/listItem.php?id=1";
        Request request = new Request.Builder()
                .url(url)
                .build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful())
                {
                    String myResponse = response.body().string();
                    try {
                        JSONObject jsonObject = new JSONObject(myResponse);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");


                        for (int i=0;i<jsonArray.length();i++)
                        {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String News_ID = object.getString("id");
                            String News_Description =  object.getString("description");
                            String News_url =  object.getString("url");

//                                    Log.d("ID",News_ID);

                            arrayList.add(i,News_url);
                            Log.d("TAG", News_ID);
                            Log.d("TAG_2", News_Description);
                            Log.d("array", News_url);


                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    News_API.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                        }
                    });
                }
            }
        });

  ////END////
        listView=findViewById(R.id.news_list);
//        title=getResources().getStringArray(R.array.title);
        MainAdapter adapter=new MainAdapter(this,title,desc,URL,arrayList);
        animation= AnimationUtils.loadAnimation(this,R.anim.animation1);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(), ""+ title[i], Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), ""+ arrayList.get(i), Toast.LENGTH_SHORT).show();
            }
        });


        }
        //////end///////


    }

