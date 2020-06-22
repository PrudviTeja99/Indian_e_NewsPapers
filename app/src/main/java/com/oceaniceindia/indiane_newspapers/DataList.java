package com.oceaniceindia.indiane_newspapers;

import android.widget.ImageView;

public class DataList {
    int image;
    String Title;
    DataList(String Title, int image){
        this.image=image;
        this.Title=Title;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return Title;
    }
}