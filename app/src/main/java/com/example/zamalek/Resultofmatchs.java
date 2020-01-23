package com.example.zamalek;


import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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


/**
 * A simple {@link Fragment} subclass.
 */
public class Resultofmatchs extends Fragment {


    public Resultofmatchs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_resultofmatchs, container, false);
        show_json(view);
        final SwipeRefreshLayout swipeRefreshLayout=view.findViewById(R.id.swip);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        show_json(view);

                    }
                },3300);
            }
        });
        return view;
    }

    private void show_json(final View view) {
        final ArrayList<Resultsofmatchs> arrayList = new ArrayList<>();
        final RecyclerView recyclerView = view.findViewById(R.id.listresult);
        String url = "https://livescore-api.com/api-client/scores/live.json?key=h5GT9nmmZDbS1oPA&secret=p8aBnyXFBYj0LjH2pnVzLiVKW7DXwtyW";
        RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject jsonObject1 = response.getJSONObject("data");
                    JSONArray jsonArray = jsonObject1.getJSONArray("match");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String status = jsonObject.getString("status");
                        Log.d("json", "status is :" + status);
                        String data = jsonObject.getString("added");
                        String league_name = jsonObject.getString("league_name");
                        String location = jsonObject.getString("location");
                        String name_home = jsonObject.getString("home_name");
                        String scour = jsonObject.getString("score");
                        String time_now = jsonObject.getString("time");
                        String name_away = jsonObject.getString("away_name");
                        Resultsofmatchs resultsofmatchs = new Resultsofmatchs(name_home, name_away, data, scour, time_now, league_name, status, location);
                        arrayList.add(resultsofmatchs);

                    }
                    Result_Adabter result_adabter = new Result_Adabter(getActivity(), arrayList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                    recyclerView.setAdapter(result_adabter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();

            }
        });
        requestQueue.add(request);
    }


}
