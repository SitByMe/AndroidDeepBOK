package com.example.zohar.androiddeepbok.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zohar.androiddeepbok.R;
import com.example.zohar.androiddeepbok.activities.fragmentlifecycle.FragmentLifecycleActivity;
import com.example.zohar.androiddeepbok.activities.activitylifecycle.LifeCycleAActivity;
import com.example.zohar.androiddeepbok.activities.motionevent.TestMotionEventActivity;
import com.example.zohar.androiddeepbok.adapter.MainRvAdapter;
import com.example.zohar.androiddeepbok.menu.MainMenu;
import com.example.zohar.androiddeepbok.mvp.constract.MainContract;
import com.example.zohar.androiddeepbok.utils.StartActivityUtils;
import com.example.zohar.androiddeepbok.widget.SimpleDividerItemDecoration;
import com.example.zohar.androiddeepbok.widget.recyclerview.BaseWithEmptyViewAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainContract.IMainPresenter> implements MainContract.IMainView {

    @BindView(R.id.rv_main)
    RecyclerView rvMain;

    private MainRvAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainContract.IMainPresenter(this, this);

        initView();
        initValues();
    }

    private void initValues() {
        presenter.initMainData();
    }

    private void initView() {
        rvMain.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvMain.addItemDecoration(new SimpleDividerItemDecoration(this, 1));
        mainAdapter = new MainRvAdapter(this);
        mainAdapter.setOnItemClickListener(new BaseWithEmptyViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (MainMenu.valueOfDesc(mainAdapter.getItem(position))) {
                    case NON:
                        break;
                    case ACTIVITY_LIFECYCLE:
                        StartActivityUtils.startActivity(MainActivity.this, LifeCycleAActivity.class);
                        break;
                    case FRAGMENT_LIFECYCLE:
                        StartActivityUtils.startActivity(MainActivity.this, FragmentLifecycleActivity.class);
                        break;
                    case MOTION_EVENT:
                        StartActivityUtils.startActivity(MainActivity.this, TestMotionEventActivity.class);
                        break;
                }
            }
        });
        rvMain.setAdapter(mainAdapter);
    }

    @Override
    public void initMainData(List<String> dataList) {
        mainAdapter.addData(dataList);
    }
}
