package com.bwie.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bwie.R;
import com.bwie.base.BaseFragment;
import com.bwie.xlistviewlibrary.utils.NetWordUtils;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class FragmentA extends BaseFragment {
    private static String urlString = "https://www.apiopen.top/satinCommentApi?id=27610708&page=1";
    @SuppressLint("HandlerLeak")
    private Handler myHanlder = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String s = (String) msg.obj;
            Toast.makeText(getActivity(),"我叫牛泓洁",Toast.LENGTH_SHORT).show();
           // Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    public int getLayout() {
        return R.layout.fragmenta;
    }

    @Override
    public void initView(View view) {
        PullToRefreshListView mListview = (PullToRefreshListView)view.findViewById(R.id.pull1);
        PullToRefreshGridView mGridview = (PullToRefreshGridView)view.findViewById(R.id.pull2);
    }


    @Override
    public void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String s = NetWordUtils.getNetjson(urlString);
                Log.e("tag","AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"+"BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
                Message message = myHanlder.obtainMessage();
                message.what=1;
                message.obj=s;
                myHanlder.sendMessage(message);
            }
        });
    }
}
