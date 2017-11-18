package ocs.com.mvp.ui.connection.contractor;

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
