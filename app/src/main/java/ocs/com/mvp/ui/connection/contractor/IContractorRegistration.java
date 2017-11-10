package ocs.com.mvp.ui.connection.contractor;
/*
 * Created by "Appsolute dev" on 11/4/2017.
 */

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
    }
}
