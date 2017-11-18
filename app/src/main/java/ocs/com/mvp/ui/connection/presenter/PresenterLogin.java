package ocs.com.mvp.ui.connection.presenter;

import android.content.Context;

import ocs.com.mvp.models.User;
import ocs.com.mvp.ui.connection.contractor.IContractorLogin;
import ocs.com.mvp.webservice.requests.RequestLogin;

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

    }

    @Override
    public void onSaveUserIntoDB(User user) {

    }
}
