package com.example.fragementtap;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    //Fragment Page Adapter
    private SectionsPagerAdapter sectionsPagerAdapter;

    //ViewPager
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Custom Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_webview);
        setSupportActionBar(toolbar);

        //Adapter for Fragement
        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager
        viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(sectionsPagerAdapter);

        //Tab in ToolBar
        TabLayout tabLayout = (TabLayout) findViewById(R.id.webview_tabs);

        //Change the page when click the tabs
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));


    }


    //Adapter for Fragement
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        //Define the Layout
        @Override
        public Fragment getItem(int position) {
           Fragment frag=null;
           switch (position){
               case 0:
                   frag=new Webview1Activity();
                   break;
               case 1:
                   frag=new WebView2Activity();
                   break;
               case 2:
                   frag=new Webview3Activity();
                   break;
           }
           return frag;

        }

        //Define # pages
        @Override
        public int getCount() {
            return 3;
        }
    }
}
