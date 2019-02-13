package com.nhj;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nhj.fragment.Fragment1;
import com.nhj.fragment.Fragment2;
import com.nhj.fragment.Fragment3;

public class MainActivity extends AppCompatActivity {


    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.main_frame,new Fragment1());
        transaction.add(R.id.main_frame,new Fragment2());
        transaction.add(R.id.main_frame,new Fragment3());
    }
}
