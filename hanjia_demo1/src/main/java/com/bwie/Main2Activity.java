package com.bwie;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bwie.base.BaseActivity;
import com.bwie.fragment.FragmentA;
import com.bwie.fragment.FragmentB;

public class Main2Activity extends BaseActivity {


    private Button mstart1;
    private Button mstart2;
    private FragmentManager manager;
    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    public int getLayout() {
        return R.layout.activity_main2;
    }

    @Override
    public void initView() {
        mstart1 = (Button)findViewById(R.id.main2_start1);
        mstart2 = (Button)findViewById(R.id.main2_start2);
    }

    @Override
    public void initData() {
        manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        fragmentTransaction.add(R.id.main2_frame,fragmentA);
        fragmentTransaction.add(R.id.main2_frame,fragmentB);
        fragmentTransaction.show(fragmentA).hide(fragmentB);
        fragmentTransaction.commit();
        mstart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = manager.beginTransaction();
                fragmentTransaction1.show(fragmentA).hide(fragmentB);
                fragmentTransaction1.commit();
            }
        });
        mstart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction1 = manager.beginTransaction();
                fragmentTransaction1.show(fragmentB).hide(fragmentA);
                fragmentTransaction1.commit();
            }
        });
    }
}
