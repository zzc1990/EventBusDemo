package com.mumayi.eventbusdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by zzc-1990 on 2017/1/7.
 */
public class TwoActivity extends Activity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main2);
    }

    public void onClick2(View view) {
        //使用eventbus
//        EventBus.getDefault().post(new Haha(18, "bj"));
        //使用broadcast
        sendMyBroadCast();
        //java方法
//        MainActivity.setData("你是谁?", context);
    }

    private void sendMyBroadCast() {
        Intent intent = new Intent();
        intent.setAction("mumayi");
        intent.putExtra("tag1", "bj");
        intent.putExtra("tag2", "changping");
        sendBroadcast(intent);
    }
}
