package com.shopspreeng.model;

import java.util.Arrays;

/**
 * Created by Thadeus on 1/25/2018.
 */

public class UserModel {

    private String name;
    private String email;
    private String gender;
    private String [] gameId; // id of all games related to user on game table
    private String [] records; // id of all game records related to games played by user

    public UserModel(String name, String email, String gender, String[] gameId, String[] records) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.gameId = gameId;
        this.records = records;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getGameId() {
        return gameId;
    }

    public void setGameId(String[] gameId) {
        this.gameId = gameId;
    }

    public String[] getRecords() {
        return records;
    }

    public void setRecords(String[] records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", gameId=" + Arrays.toString(gameId) +
                ", records=" + Arrays.toString(records) +
                '}';
    }
}
