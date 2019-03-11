package com.example.zohar.androiddeepbok.activities.motionevent;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Switch;

import com.example.zohar.androiddeepbok.R;
import com.example.zohar.androiddeepbok.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestMotionEventActivity extends AppCompatActivity {
    private final String TAG = "事件传递测试 - ";
    @BindView(R.id.cl_root)
    ConstraintLayout clRoot;
    @BindView(R.id.rl_second)
    RelativeLayout rlSecond;
    @BindView(R.id.btn_third)
    AppCompatButton btnThird;
    @BindView(R.id.switch_root)
    Switch switchRoot;
    @BindView(R.id.switch_second)
    Switch switchSecond;
    @BindView(R.id.switch_third)
    Switch switchThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_motion_event);
        ButterKnife.bind(this);

        clRoot.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                LogUtils.v(TAG.concat("root"), event.toString());
                return switchRoot.isChecked();
            }
        });
        rlSecond.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                LogUtils.v(TAG.concat("second"), event.toString());
                return switchSecond.isChecked();
            }
        });
        btnThird.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                LogUtils.v(TAG.concat("third"), event.toString());
                return false;
            }
        });
    }
}
