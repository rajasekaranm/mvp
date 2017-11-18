package ocs.com.mvp.ui.connection.contractor;
/*
 * Created by "Appsolute dev" on 11/15/2017.
 */

import ocs.com.mvp.models.User;
import ocs.com.mvp.webservice.requests.RequestLogin;
import ocs.com.mvp.webservice.requests.RequestRegister;

public interface IContractorLogin {

    interface ILoginPresenter {
        void launchLoginAPI(RequestLogin requestLogin);

        void onSaveUserIntoDB(User user);
    }

    interface ILoginView {
        void onAPILoginSuccess();

        void onAPILoginFailed(String reason);

        void initToolbar();

        boolean areFieldsValid();

        RequestLogin getLoginRequest();

        void openHome();
    }

}
