package ocs.com.mvp.ui.connection.contractor;


import ocs.com.mvp.databinding.ActivityRegistrationBinding;
import ocs.com.mvp.models.User;
import ocs.com.mvp.webservice.requests.RequestRegister;

public interface IContractorRegistration {

    interface IRegistrationPresenter {
        void launchRegisterAPI(ActivityRegistrationBinding binding);

        void onSaveUserIntoDB(User user);

        boolean areFieldsValid(ActivityRegistrationBinding binding);

        RequestRegister getRequestRegister(ActivityRegistrationBinding binding);


    }

    interface IRegistrationView {
        void onAPIRegisterSuccess();

        void onAPIRegisterFailed(String reason);

        void initToolbar();
    }
}
