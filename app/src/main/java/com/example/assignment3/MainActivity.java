package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.view.textclassifier.TextLanguage;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
List<Items> productList;
    RecyclerView recyclerView;
private  static  String Jason="https://github.com/revolunet/PythonBooks/blob/master/issues.json";
Adapter1 adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      recyclerView= findViewById(R.id.list_item);

        productList = new ArrayList<>();
        extractData();
    }

    private void extractData() {
        RequestQueue queue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Jason, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        Items items = new Items();
                        items.setTitle(jsonObject.getString("title").toString());
                        items.setInfo(jsonObject.getString("info").toString());
                        items.setAuthor(jsonObject.getString("author").toString());
                        items.setLevel(jsonObject.getString("level").toString());
                        items.setAuthorUr(jsonObject.getString("authorUrl"));
                        items.setCover(jsonObject.getString("cover"));
                        items.setUrl(jsonObject.getString("url"));

                        productList.add(items);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter1=new Adapter1((MainActivity) getApplicationContext(),productList);
                recyclerView.setAdapter(adapter1);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse: " + error.getMessage());

            }
        });
        queue.add(jsonArrayRequest);
    }
}


















