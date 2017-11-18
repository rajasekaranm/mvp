package ocs.com.mvp.webservice.requests;
/*
 * Created by "Appsolute dev" on 11/18/2017.
 */

import com.google.gson.annotations.SerializedName;

public class RequestLogin {
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
