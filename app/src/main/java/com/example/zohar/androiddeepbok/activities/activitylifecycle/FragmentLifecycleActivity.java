package com.example.zohar.androiddeepbok.activities.activitylifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.example.zohar.androiddeepbok.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentLifecycleActivity extends AppCompatActivity {

    @BindView(R.id.fl_first)
    FrameLayout flFirst;
    @BindView(R.id.fl_second)
    FrameLayout flSecond;

    private LifecycleFragment first1Fragment;
    private LifecycleFragment first2Fragment;

    private LifecycleFragment second1Fragment;
    private LifecycleFragment second2Fragment;
    private List<LifecycleFragment> secondFragmentList;
    private int currentSIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_lifecycle);
        ButterKnife.bind(this);

        secondFragmentList = new ArrayList<>();
        secondFragmentList.add(second1Fragment);
        secondFragmentList.add(second2Fragment);
        currentSIndex = 0;
        initFragments();
    }

    private void initFragments() {
        first1Fragment = createFragment("first1Fragment");
        first2Fragment = createFragment("first2Fragment");
        second1Fragment = createFragment("second1Fragment");
        second2Fragment = createFragment("second2Fragment");

        getSupportFragmentManager().beginTransaction().add(R.id.fl_first, first1Fragment, "f1").add(R.id.fl_second, second1Fragment, "s1").commit();
//        getSupportFragmentManager().beginTransaction().add(R.id.fl_second, secondFragmentList.get(currentSIndex), "s1").commit();
    }

    private LifecycleFragment createFragment(String tag) {
        LifecycleFragment fragment = new LifecycleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", tag);
        fragment.setArguments(bundle);
        return fragment;
    }

    @OnClick({R.id.btn_first_1, R.id.btn_first_2, R.id.btn_second})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_first_1:
                if (first1Fragment.isAdded()) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_first, first1Fragment, "f1").commit();
                } else {
                    getSupportFragmentManager().beginTransaction().add(R.id.fl_first, first1Fragment, "f1").commit();
                }
                break;
            case R.id.btn_first_2:
                if (first2Fragment.isAdded()) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_first, first2Fragment, "f2").commit();
                } else {
                    getSupportFragmentManager().beginTransaction().add(R.id.fl_first, first2Fragment, "f2").commit();
                }
                break;
            case R.id.btn_second:
                currentSIndex = (currentSIndex + 1) % secondFragmentList.size();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_second, currentSIndex == 0 ? second1Fragment : second2Fragment, currentSIndex == 0 ? "s1" : "s2").commit();
                break;
        }
    }
}
