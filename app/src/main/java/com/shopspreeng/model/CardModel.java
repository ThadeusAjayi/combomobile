package com.shopspreeng.model;

import com.google.gson.Gson;

/**
 * Created by Thadeus on 1/24/2018.
 */

public class CardModel {

    private int cardNum;
    private String cardName;
    private int cardResource;

    public CardModel(int cardNum, String cardName, int cardResource) {
        this.cardNum = cardNum;
        this.cardName = cardName;
        this.cardResource = cardResource;
    }

    public int getCardNum() {
        return cardNum;
    }

    public String getCardName() {
        return cardName;
    }

    public int getCardResource() {
        return cardResource;
    }

    public static String toJson (CardModel card) {
        Gson gson = new Gson();
        return gson.toJson(card);
    }

}
