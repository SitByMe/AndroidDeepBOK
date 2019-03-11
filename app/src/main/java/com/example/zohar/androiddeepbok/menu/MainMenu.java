package com.example.zohar.androiddeepbok.menu;

import android.view.View;

public enum MainMenu {
    NON(View.NO_ID, "错误"), ACTIVITY_LIFECYCLE(0, "Activity生命周期"), FRAGMENT_LIFECYCLE(1, "Fragment生命周期"), MOTION_EVENT(2, "Android事件分发机制");

    public int index;
    public String desc;

    MainMenu(int index, String desc) {
        this.index = index;
        this.desc = desc;
    }

    public static MainMenu valueOfDesc(String desc) {
        for (MainMenu item : MainMenu.values()) {
            if (desc.equals(item.desc)) return item;
        }
        return NON;
    }
}
