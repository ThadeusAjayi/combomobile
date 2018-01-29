package com.shopspreeng.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

/**
 * Created by Thadeus on 1/27/2018.
 */

public class SampleChatModel implements Parcelable{

    private String message, sender;

    public SampleChatModel(String message, String sender) {
        this.message = message;
        this.sender = sender;
    }

    protected SampleChatModel(Parcel in) {
        message = in.readString();
        sender = in.readString();
    }

    public static final Creator<SampleChatModel> CREATOR = new Creator<SampleChatModel>() {
        @Override
        public SampleChatModel createFromParcel(Parcel in) {
            return new SampleChatModel(in);
        }

        @Override
        public SampleChatModel[] newArray(int size) {
            return new SampleChatModel[size];
        }
    };

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }

    public static String toJson(SampleChatModel chat) {
        Gson obj = new Gson();
        return obj.toJson(chat);
    }

    @Override
    public String toString() {
        return "SampleChatModel{" +
                "message='" + message + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
        dest.writeString(sender);
    }
}
