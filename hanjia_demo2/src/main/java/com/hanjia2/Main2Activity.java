package com.hanjia2;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.hanjia2.base.BaseActivity;
import com.hanjia2.util.MyUtil;

public class Main2Activity extends BaseActivity {

    private static String urlString = "https://api.yunxuekeji.cn/yunxue_app_api/content/getIndexBanner/1";
    private PullToRefreshListView mListView;

    @Override
    public int getLayout() {
        return R.layout.activity_main2;
    }

    @Override
    public void initView() {
        mListView = (PullToRefreshListView)findViewById(R.id.main2_listview);
    }

    @Override
    public void initData() {

        new Mysnc().execute(urlString);
    }
     class Mysnc extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            return MyUtil.getData(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
           Toast.makeText(Main2Activity.this,s+"牛泓洁",Toast.LENGTH_SHORT).show();
        }
    }
}
