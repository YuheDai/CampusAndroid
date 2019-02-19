package com.daiyuhe.campussecurity.activity;

import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.daiyuhe.campussecurity.R;
import com.daiyuhe.campussecurity.receiver.MessageReceiver;
import com.daiyuhe.campussecurity.utils.Keys;

import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mGetRid;
    private TextView mRegId;

    //for receive customer msg from jpush server
    private MessageReceiver mMessageReceiver;

    public static boolean isForeground = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JPushInterface.init(getApplicationContext());
        initView();
        registerMessageReceiver();  // used for receive msg
    }

    private void initView(){
        mGetRid = findViewById(R.id.getRegistrationId);
        mGetRid.setOnClickListener(this);

        mRegId = findViewById(R.id.tv_regId);
        mRegId.setText("RegId:");
    }

    public void registerMessageReceiver() {
        mMessageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        filter.addAction(Keys.MESSAGE_RECEIVED_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, filter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.getRegistrationId:
                String rid = JPushInterface.getRegistrationID(getApplicationContext());
                if (!rid.isEmpty()) {
                    mRegId.setText("RegId:" + rid);
                } else {
                    Toast.makeText(this, "Get registration fail, JPush init failed!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
