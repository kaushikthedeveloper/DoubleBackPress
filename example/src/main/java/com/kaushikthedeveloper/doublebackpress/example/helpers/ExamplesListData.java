package com.kaushikthedeveloper.doublebackpress.example.helpers;

/**
 * Created by Kaushik NP (https://github.com/kaushikthedeveloper) on 09-03-2018.
 * Used for List DataStructure : store values of each card
 */
public class ExamplesListData {
    private String title;
    private String info;

    public ExamplesListData(String title, String info){
        this.title = title;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public String getTitle() {
        return title;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
