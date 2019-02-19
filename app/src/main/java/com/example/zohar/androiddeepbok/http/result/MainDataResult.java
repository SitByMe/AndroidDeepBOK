package com.example.zohar.androiddeepbok.http.result;

import java.util.ArrayList;
import java.util.List;

public class MainDataResult extends BaseResult {
    private List<String> dataList;

    public List<String> getDataList() {
        return dataList != null ? dataList : new ArrayList<String>();
    }

    public void setDataList(List<String> dataList) {
        this.dataList = dataList;
    }
}
