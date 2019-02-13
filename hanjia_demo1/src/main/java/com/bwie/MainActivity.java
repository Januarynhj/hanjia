package com.bwie;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.bwie.adapter.ViewPagerAdapter;
import com.bwie.base.BaseActivity;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private ViewPager viewpager;
    private RadioGroup rg;
    private ArrayList<Integer> list;
    private Button mstart;
    private int i;
    private Handler myhandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            i++;
            viewpager.setCurrentItem(i);
            myhandler.sendEmptyMessageDelayed(1,1000);
        }
    };
    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        viewpager = (ViewPager)findViewById(R.id.main_viewpager);
        rg = (RadioGroup)findViewById(R.id.main_rg);
        mstart = (Button)findViewById(R.id.main_start);


        list = new ArrayList<>();
        list.add(R.mipmap.a);
        list.add(R.mipmap.b);
        list.add(R.mipmap.c);
        ViewPagerAdapter myAdapter = new ViewPagerAdapter(list, MainActivity.this);
        viewpager.setAdapter(myAdapter);
        viewpager.setCurrentItem(i);
        myhandler.sendEmptyMessageDelayed(1,1000);
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i%list.size()){
                    case 0:
                        rg.check(R.id.rb1);
                        mstart.setVisibility(View.INVISIBLE);
                        break;case 1:
                        rg.check(R.id.rb2);
                        mstart.setVisibility(View.INVISIBLE);
                        break;case 2:
                        rg.check(R.id.rb3);
                        mstart.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void initData() {
        mstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }

}
