package com.mumayi.eventbusdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by zzc-1990 on 2017/1/8.
 */

public class MyBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        if (action.equals("mumayi")) {
            String tag1 = intent.getStringExtra("tag1");
            String tag2 = intent.getStringExtra("tag2");

            Toast.makeText(context, "是啥" + tag1 + "&" + tag2, Toast.LENGTH_SHORT).show();
            MainActivity.rl_tv.setText(tag2);
        }

    }
}
