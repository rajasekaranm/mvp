package ocs.com.mvp.webservice.requests;
/*
 * Created by "Appsolute dev" on 11/4/2017.
 */

import com.google.gson.annotations.SerializedName;

public class RequestRegister {

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("email")
    private String email;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("password")
    private String password;
    @SerializedName("confirm_password")
    private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
