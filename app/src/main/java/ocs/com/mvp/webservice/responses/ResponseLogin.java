package ocs.com.mvp.webservice.responses;


import com.google.gson.annotations.SerializedName;

import ocs.com.mvp.models.User;

public class ResponseLogin {
    @SerializedName("status")
    private ResponseStatus status;

    @SerializedName("user")
    private User user;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
