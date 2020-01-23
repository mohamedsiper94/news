package com.example.zamalek;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.zamalek.R;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Internationalnews_Fragment extends Fragment {
    ArrayList<NewsInaternational> arrayList;
    RecycleviewAdapter recycleviewAdapter;
    RecyclerView recyclerView;

    public Internationalnews_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_internationalnews_, container, false);
        arrayList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.rec);
        RequestQueue rq = Volley.newRequestQueue(view.getContext());
        String url = "https://newsapi.org/v2/top-headlines?country=eg&category=sports&apiKey=5109757a98ff41f189ffb17ab9488560";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("articles");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject posts = jsonArray.getJSONObject(i);
                        String title = posts.getString("title");
                        String duration = posts.getString("publishedAt");
                        String url = posts.getString("url");
                        String url_image = posts.getString("urlToImage");
                        String description = posts.getString("description");
                        NewsInaternational newsInaternational = new NewsInaternational(title, url, url_image, duration, description);
                        arrayList.add(newsInaternational);
                    }
                    recycleviewAdapter = new RecycleviewAdapter(getActivity(), arrayList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                    recyclerView.setAdapter(recycleviewAdapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        rq.add(jsonObjectRequest);

        return view;
    }

    public static class MainActivity extends AppCompatActivity {
        TabLayout tabLayout;
        ViewPager viewPager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);






            tabLayout = findViewById(R.id.tablayout);
            viewPager = findViewById(R.id.viewpager);

            setupViewPager(viewPager);
            tabLayout.setupWithViewPager(viewPager);

            tabLayout.getTabAt(0).setIcon(R.drawable.ic_launcher_background);
            tabLayout.getTabAt(1).setIcon(R.drawable.ic_launcher_background);
            tabLayout.getTabAt(2).setIcon(R.drawable.ic_launcher_background);
        }

        private void setupViewPager(ViewPager viewPager1) {

            ViewPagerAdabter adabter = new ViewPagerAdabter(getSupportFragmentManager());
            adabter.addFragment(new Zamaleknews_Fragmet(), "اخبار الزمالك");
            adabter.addFragment(new Resultofmatchs(), "نتائج المباريات");
            adabter.addFragment(new Internationalnews_Fragment(), "اخبار رياضية");
            viewPager1.setAdapter(adabter);


        }


        class ViewPagerAdabter extends FragmentPagerAdapter {
            private final ArrayList<Fragment> fragments = new ArrayList<>();
            private final ArrayList<String> strings = new ArrayList<>();

            ViewPagerAdabter(@NonNull FragmentManager fm) {
                super(fm);
            }

            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            void addFragment(Fragment fragment, String title) {
                fragments.add(fragment);
                strings.add(title);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {


                return strings.get(position);
            }


        }

    }
}
