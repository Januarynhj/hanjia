package com.hanjia2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hanjia2.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private Button mjump;
    private int i=3;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(i>0){
                i--;
                mjump.setText(i+"秒");
                mHandler.sendEmptyMessageDelayed(1,1000);
            }else{
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        }
    };
    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mjump = (Button)findViewById(R.id.main_jump);
    }

    @Override
    public void initData() {
        mHandler.sendEmptyMessageDelayed(1,1000);
        mjump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeMessages(1);
    }
}
