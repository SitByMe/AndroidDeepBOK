package com.example.zohar.androiddeepbok.activities.fragmentlifecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zohar.androiddeepbok.R;
import com.example.zohar.androiddeepbok.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LifecycleFragment extends Fragment {
    private String TAG = getClass().getSimpleName();

    @BindView(R.id.tv_content)
    AppCompatTextView tvContent;
    Unbinder unbinder;

    private String text = "";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        LogUtils.v(TAG, "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.v(TAG.concat(text), "onCreate");
        if (getArguments() != null) {
            text = getArguments().getString("text");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LogUtils.v(TAG.concat(text), "onCreateView");
        View view = inflater.inflate(R.layout.fragment_lifecycle, container, false);
        unbinder = ButterKnife.bind(this, view);
        tvContent.setText(text);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtils.v(TAG.concat(text), "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.v(TAG.concat(text), "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.v(TAG.concat(text), "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.v(TAG.concat(text), "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.v(TAG.concat(text), "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.v(TAG.concat(text), "onDestroyView");
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.v(TAG.concat(text), "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtils.v(TAG.concat(text), "onDetach");
    }
}
