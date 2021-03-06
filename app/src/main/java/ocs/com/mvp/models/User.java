package ocs.com.mvp.models;
/*
 * Created by "Appsolute dev" on 11/4/2017.
 */

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("userId")
    private int userId;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("gender")
    private int gender;
    @SerializedName("email")
    private String email;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("dob")
    private String dob;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}

