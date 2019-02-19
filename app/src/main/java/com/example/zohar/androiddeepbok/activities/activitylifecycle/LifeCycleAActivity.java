package com.example.zohar.androiddeepbok.activities.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.zohar.androiddeepbok.R;
import com.example.zohar.androiddeepbok.activities.BaseActivity;
import com.example.zohar.androiddeepbok.utils.LogUtils;
import com.example.zohar.androiddeepbok.utils.StartActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LifeCycleAActivity extends BaseActivity {
    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_a);
        ButterKnife.bind(this);
        LogUtils.d(TAG, "onCreate");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.d(TAG, "onNewIntent");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.d(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtils.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtils.d(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtils.d(TAG, "onActivityResult");
    }

    @OnClick({R.id.btn_normal, R.id.btn_with_req_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_normal:
                StartActivityUtils.startActivity(LifeCycleAActivity.this, LifeCycleBActivity.class);
                break;
            case R.id.btn_with_req_code:
                StartActivityUtils.startActivityForResult(LifeCycleAActivity.this, LifeCycleBActivity.class, 0x001);
                break;
        }
    }
}
