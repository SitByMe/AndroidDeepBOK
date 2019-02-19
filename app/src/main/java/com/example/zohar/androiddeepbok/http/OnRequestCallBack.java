package com.example.zohar.androiddeepbok.http;

import com.example.zohar.androiddeepbok.http.result.BaseResult;
import com.example.zohar.androiddeepbok.http.result.ResultModel;

public interface OnRequestCallBack<BR extends BaseResult> {
    void onError(Exception e);

    void onCompleted();

    void onNext(ResultModel<BR> result);
}
