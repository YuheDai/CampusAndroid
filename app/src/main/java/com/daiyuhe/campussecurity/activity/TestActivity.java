package com.daiyuhe.campussecurity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daiyuhe.campussecurity.R;

import cn.jpush.android.api.JPushInterface;

public class TestActivity extends Activity implements View.OnClickListener {

    private TextView titleTextView;
    private TextView contentTextView;
    private Button button1;
    private Button button2;

    public TestActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_test);
        initView();

        if (null != intent) {
            Bundle bundle = getIntent().getExtras();
            String title = null;
            String content = null;
            if (bundle != null) {
                title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
                content = bundle.getString(JPushInterface.EXTRA_ALERT);
            }
            titleTextView.setText(title);
            contentTextView.setText(content);
        }
    }

    private void initView() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        titleTextView = findViewById(R.id.title);
        contentTextView = findViewById(R.id.content);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
            case R.id.button2:
                finish();
                break;
            default:
                break;
        }
    }
}
