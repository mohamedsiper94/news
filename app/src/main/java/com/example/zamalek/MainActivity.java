package com.example.zamalek;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
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

