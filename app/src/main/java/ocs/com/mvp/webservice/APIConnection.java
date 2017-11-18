package ocs.com.mvp.webservice;


import ocs.com.mvp.webservice.requests.RequestLogin;
import ocs.com.mvp.webservice.requests.RequestRegister;
import ocs.com.mvp.webservice.responses.ResponseLogin;
import ocs.com.mvp.webservice.responses.ResponseRegistration;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIConnection {

    @POST(APIConstant.REGISTRATION)
    Call<ResponseRegistration> register(@Body RequestRegister requestRegister);

    @POST(APIConstant.LOGIN)
    Call<ResponseLogin> login(@Body RequestLogin requestLogin);
}
