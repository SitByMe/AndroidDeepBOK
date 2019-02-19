package com.example.zohar.androiddeepbok.mvp.constract;

import android.content.Context;

import com.example.zohar.androiddeepbok.http.OnRequestCallBack;
import com.example.zohar.androiddeepbok.http.result.MainDataResult;
import com.example.zohar.androiddeepbok.http.result.ResultModel;
import com.example.zohar.androiddeepbok.mvp.IBaseView;
import com.example.zohar.androiddeepbok.mvp.model.MainModel;
import com.example.zohar.androiddeepbok.mvp.presenter.BasePresenter;

import java.util.List;

public class MainContract {

    public interface IMainView extends IBaseView {
        void initMainData(List<String> dataList);
    }

    public static class IMainPresenter extends BasePresenter<MainModel, IMainView> {

        public IMainPresenter(Context context, IMainView view) {
            setModel(new MainModel());
            attachView(view);
        }

        public void initMainData() {
            getModel().initMainData(new OnRequestCallBack<MainDataResult>() {
                @Override
                public void onError(Exception e) {

                }

                @Override
                public void onCompleted() {

                }

                @Override
                public void onNext(ResultModel<MainDataResult> result) {
                    getView().initMainData(result.data.getDataList());
                }
            });
        }
    }
}
