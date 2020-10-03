package com.example.rebrojsonweb_;

import android.app.Activity;
import android.os.Bundle;



import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends Activity {
    RecyclerView mRecyclerView;
    ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        String url = "https://run.mocky.io/v3/b8b15165-0686-47f3-b55c-340bce926dc4";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("users");
                            for ( int i = 0; i < jsonArray.length(); i++) {
                                JSONObject employee = jsonArray.getJSONObject(i);

                                JSONObject addressObject = employee.getJSONObject("contact");
                                String phoneH = addressObject.getString("home");
                                String phoneO = addressObject.getString("office");
                                String mobile = addressObject.getString("mobile");
                                String firstName = employee.getString("name");
                                String id =  employee.getString("id");
                                String gender = employee.getString("gender");
                                String mail = employee.getString("email");
                                mExampleList.add(new ExampleItem(id,    firstName,   gender,   mail,   phoneH,   phoneO,   mobile));
                            }

                            mExampleAdapter = new ExampleAdapter(MainActivity.this, mExampleList);
                            mRecyclerView.setAdapter(mExampleAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }
}