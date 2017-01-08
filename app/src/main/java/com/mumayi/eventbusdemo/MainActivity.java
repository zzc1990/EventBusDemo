package com.mumayi.eventbusdemo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 使用eventbus/broadcast/java方法,在两个activity之间传递数据
 */

public class MainActivity extends Activity {

    public static TextView rl_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        rl_tv = (TextView) findViewById(R.id.rl_tv);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onClick(View view) {

        Intent intent = new Intent(this, TwoActivity.class);
        startActivity(intent);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void ReceiveMethod(Haha haha) {
        Toast.makeText(this, "是啥" + haha.getAge() + "&" + haha.getAdd(), Toast.LENGTH_SHORT).show();
        System.out.println("是啥" + haha.getAge() + "&" + haha.getAdd());
    }


    public static void setData(String string, Context context) {
        Toast.makeText(context, "内容是:" + string, Toast.LENGTH_SHORT).show();
    }
}
