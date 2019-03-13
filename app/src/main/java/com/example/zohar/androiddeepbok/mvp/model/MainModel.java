package com.example.zohar.androiddeepbok.mvp.model;

import com.example.zohar.androiddeepbok.http.OnRequestCallBack;
import com.example.zohar.androiddeepbok.http.result.MainDataResult;
import com.example.zohar.androiddeepbok.http.result.ResultModel;
import com.example.zohar.androiddeepbok.menu.MainMenu;

import java.util.ArrayList;
import java.util.List;

public class MainModel extends BaseModel {
    public void initMainData(OnRequestCallBack<MainDataResult> callBack) {
        List<String> dataList = new ArrayList<>();
        for (MainMenu mainMenu : MainMenu.values()) {   
            if (mainMenu != MainMenu.NON) dataList.add(mainMenu.desc);
        }
        ResultModel<MainDataResult> result = new ResultModel<>();
        MainDataResult baseResult = new MainDataResult();
        baseResult.setDataList(dataList);
        result.data = baseResult;
        callBack.onNext(result);
    }
}
