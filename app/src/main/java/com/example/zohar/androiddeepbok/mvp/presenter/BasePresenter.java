package com.example.zohar.androiddeepbok.mvp.presenter;

import com.example.zohar.androiddeepbok.mvp.IBasePresenter;
import com.example.zohar.androiddeepbok.mvp.IBaseView;
import com.example.zohar.androiddeepbok.mvp.model.BaseModel;

public abstract class BasePresenter<M extends BaseModel, V extends IBaseView> implements IBasePresenter<V> {
    private M model;
    private V view;

    public void setModel(M model) {
        this.model = model;
    }

    public M getModel() {
        return model;
    }

    public void attachView(V view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    public V getView() {
        return view;
    }
}
