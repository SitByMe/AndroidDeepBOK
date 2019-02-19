package com.example.zohar.androiddeepbok.menu;

import android.view.View;

public enum MainMenu {
    NON(View.NO_ID, "错误"), ACTIVITY_LIFE_CYCLE(0, "Activity生命周期");

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
