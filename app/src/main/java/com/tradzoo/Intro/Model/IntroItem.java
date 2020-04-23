package com.tradzoo.Intro.Model;

public class IntroItem {
    int introImage;
    String introTitle, introDescription;

    public IntroItem(int introImage, String introTitle, String introDescription) {
        this.introImage = introImage;
        this.introTitle = introTitle;
        this.introDescription = introDescription;
    }

    public IntroItem() {
    }

    public int getIntroImage() {
        return introImage;
    }

    public void setIntroImage(int introImage) {
        this.introImage = introImage;
    }

    public String getIntroTitle() {
        return introTitle;
    }

    public void setIntroTitle(String introTitle) {
        this.introTitle = introTitle;
    }

    public String getIntroDescription() {
        return introDescription;
    }

    public void setIntroDescription(String introDescription) {
        this.introDescription = introDescription;
    }
}
