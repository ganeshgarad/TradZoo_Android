package com.tradzoo.TradeCategory.Model;

public class TradeCategory {
    String categoryTitle;
    String buyCall,sellCall;
    String cardColor;

    public TradeCategory(String categoryTitle, String buyCall, String sellCall,String cardColor) {
        this.categoryTitle = categoryTitle;
        this.buyCall = buyCall;
        this.sellCall = sellCall;
        this.cardColor = cardColor;
    }

    public TradeCategory() {
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public String getCardColor() {
        return cardColor;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getBuyCall() {
        return buyCall;
    }

    public void setBuyCall(String buyCall) {
        this.buyCall = buyCall;
    }

    public String getSellCall() {
        return sellCall;
    }

    public void setSellCall(String sellCall) {
        this.sellCall = sellCall;
    }
}
