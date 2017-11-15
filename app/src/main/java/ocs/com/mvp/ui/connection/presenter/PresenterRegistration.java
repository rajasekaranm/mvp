package ocs.com.mvp.ui.connection.presenter;


import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import ocs.com.mvp.databinding.ActivityRegistrationBinding;
import ocs.com.mvp.models.User;
import ocs.com.mvp.ui.connection.contractor.IContractorRegistration;
import ocs.com.mvp.webservice.APIClient;
import ocs.com.mvp.webservice.APIConnection;
import ocs.com.mvp.webservice.requests.RequestRegister;
import ocs.com.mvp.webservice.responses.ResponseRegistration;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterRegistration implements IContractorRegistration.IRegistrationPresenter {
    private IContractorRegistration.IRegistrationView iRegistrationView;
    private Context context;

    public PresenterRegistration(IContractorRegistration.IRegistrationView iRegistrationView, Context context) {
        this.iRegistrationView = iRegistrationView;
        this.context = context;
    }

    //restrofit api call
    @Override
    public void launchRegisterAPI(RequestRegister requestRegister) {

            APIConnection apiConnection = APIClient.getClient().create(APIConnection.class);
            Call<ResponseRegistration> call = apiConnection.register(requestRegister);
            call.enqueue(new Callback<ResponseRegistration>() {
                @Override
                public void onResponse(Call<ResponseRegistration> call, Response<ResponseRegistration> response) {
                    if (response.body() != null) {
                        onSaveUserIntoDB(response.body().getUser());
                        iRegistrationView.onAPIRegisterSuccess();
                    } else {
                        iRegistrationView.onAPIRegisterFailed("Invalid response");
                    }
                }

                @Override
                public void onFailure(Call<ResponseRegistration> call, Throwable t) {
                    iRegistrationView.onAPIRegisterFailed("Failed");
                }
            });


    }

    /*
    Save user data into database
     */
    @Override
    public void onSaveUserIntoDB(User user) {

    }





}
