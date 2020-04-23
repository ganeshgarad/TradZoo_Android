package com.tradzoo.Home.Model;

public class Home {
    String title,colorCode;

    public Home(String title, String colorCode) {
        this.title = title;
        this.colorCode = colorCode;
    }

    public Home() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }
}
