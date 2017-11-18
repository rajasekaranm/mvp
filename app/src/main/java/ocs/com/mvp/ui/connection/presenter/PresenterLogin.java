package ocs.com.mvp.ui.connection.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import ocs.com.mvp.models.User;
import ocs.com.mvp.ui.connection.contractor.IContractorLogin;
import ocs.com.mvp.webservice.APIClient;
import ocs.com.mvp.webservice.APIConnection;
import ocs.com.mvp.webservice.requests.RequestLogin;
import ocs.com.mvp.webservice.responses.ResponseLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
 * Created by "Appsolute dev" on 11/18/2017.
 */

public class PresenterLogin implements IContractorLogin.ILoginPresenter {
    private Context context;
    private IContractorLogin.ILoginView iLoginView;

    public PresenterLogin(Context context, IContractorLogin.ILoginView iLoginView) {
        this.context = context;
        this.iLoginView = iLoginView;
    }

    @Override
    public void launchLoginAPI(RequestLogin requestLogin) {
        APIConnection apiConnection = APIClient.getClient().create(APIConnection.class);
        Call<ResponseLogin> call = apiConnection.login(requestLogin);
        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(@NonNull Call<ResponseLogin> call, @NonNull Response<ResponseLogin> response) {
                iLoginView.onAPILoginSuccess();
                if (response.body() != null) {
                    onSaveUserIntoDB(response.body().getUser());
                    iLoginView.onAPILoginSuccess();
                } else {
                    iLoginView.onAPILoginFailed("Invalid response");
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseLogin> call, @NonNull Throwable t) {
                iLoginView.onAPILoginFailed("failed");
            }
        });

    }

    @Override
    public void onSaveUserIntoDB(User user) {

    }
}
