package com.shopspreeng.model;

import com.google.gson.Gson;

/**
 * Created by Thadeus on 1/28/2018.
 */

public class SampleChatListModel {

    private String createdby;
    private String chatwith;
    private String _id;

    public SampleChatListModel(String createdby, String chatwith, String _id) {
        this.createdby = createdby;
        this.chatwith = chatwith;
        this._id = _id;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getChatwith() {
        return chatwith;
    }

    public String get_id() {
        return _id;
    }

    public static String toJson(SampleChatListModel chatList) {
        Gson obj = new Gson();
        return obj.toJson(chatList);
    }

    @Override
    public String toString() {
        return "SampleChatListModel{" +
                "createdby='" + createdby + '\'' +
                ", chatwith='" + chatwith + '\'' +
                ", _id='" + _id + '\'' +
                '}';
    }
}
