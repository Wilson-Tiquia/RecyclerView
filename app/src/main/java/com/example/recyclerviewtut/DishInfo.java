package com.example.recyclerviewtut;

import android.graphics.Bitmap;

public class DishInfo {
    private String dishName;
    private Bitmap dishImage;

    public DishInfo(String dishName, Bitmap dishImage) {
        this.dishName = dishName;
        this.dishImage = dishImage;
    }

    public String getDishName() {
        return dishName;
    }

    public Bitmap getDishImage() {
        return dishImage;
    }
}
