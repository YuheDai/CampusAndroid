package com.daiyuhe.campussecurity.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.daiyuhe.campussecurity.utils.ExampleUtil;
import com.daiyuhe.campussecurity.utils.Keys;


public class MessageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            if (Keys.MESSAGE_RECEIVED_ACTION.equals(intent.getAction())) {
                String messge = intent.getStringExtra(Keys.KEY_MESSAGE);
                String extras = intent.getStringExtra(Keys.KEY_EXTRAS);
                StringBuilder showMsg = new StringBuilder();
                showMsg.append(Keys.KEY_MESSAGE + " : " + messge + "\n");
                if (!ExampleUtil.isEmpty(extras)) {
                    showMsg.append(Keys.KEY_EXTRAS + " : " + extras + "\n");
                }
//                setCostomMsg(showMsg.toString());
            }
        } catch (Exception e) {
        }
    }

}
