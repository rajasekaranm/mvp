package ocs.com.mvp.ui.connection.contractor;


import ocs.com.mvp.models.User;
import ocs.com.mvp.webservice.requests.RequestRegister;

public interface IContractorRegistration {

    interface IRegistrationPresenter {
        void launchRegisterAPI(RequestRegister requestRegister);

        void onSaveUserIntoDB(User user);

    }

    interface IRegistrationView {
        void onAPIRegisterSuccess();

        void onAPIRegisterFailed(String reason);

        void initToolbar();

        boolean areFieldsValid();

        RequestRegister getRequestRegister();
        void openHome();
    }
}
