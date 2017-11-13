package ocs.com.mvp.ui.connection.contractor;


import ocs.com.mvp.databinding.ActivityRegistrationBinding;

public interface IContractorRegistration {

    interface IRegistrationPresenter {
        void launchRegisterAPI(ActivityRegistrationBinding binding);

        boolean areFieldsValid(ActivityRegistrationBinding binding);


    }

    interface IRegistrationView {
        void showAPIRegisterSuccess();

        void showAPIRegisterFailes();

        void showAlertForInvalidRequest();

        void initToolbar();
    }
}
