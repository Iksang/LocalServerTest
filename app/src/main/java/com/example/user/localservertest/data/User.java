package com.example.user.localservertest.data;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tjoeun on 2017-11-17.
 */

public class User {

    private int id;
    private String name;
    private String birthDay;
    private boolean gender;
    private String address;
    private String phone;
    private String profile_url;
    private int height;


    public static User getLectureFromJson(JSONObject jsonObject){
        User user = new User();

        try {
            user.id = jsonObject.getInt("id");
            user.name = jsonObject.getString("name");
            user.birthDay= jsonObject.getString("start_date");
            user.gender = jsonObject.getBoolean("gender");
            user.address= jsonObject.getString("address");
            user.phone = jsonObject.getString("phone");
            user.profile_url = jsonObject.getString("profile_url");
            user.height = jsonObject.getInt("height");


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return user;
    }

    public User() {
    }

    public User(int id, String name, String birthDay, boolean gender, String address, String phone, String profile_url, int height) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.profile_url = profile_url;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
