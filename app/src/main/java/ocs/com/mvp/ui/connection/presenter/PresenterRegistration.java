package ocs.com.mvp.ui.connection.presenter;
/*
 * Created by "Appsolute dev" on 11/4/2017.
 */

import android.content.Context;


import ocs.com.mvp.databinding.ActivityRegistrationBinding;
import ocs.com.mvp.ui.connection.contractor.IContractorRegistration;

public class PresenterRegistration implements IContractorRegistration.IRegistrationPresenter {
    private IContractorRegistration.IRegistrationView iRegistrationView;
    private Context context;

    public PresenterRegistration(IContractorRegistration.IRegistrationView iRegistrationView, Context context) {
        this.iRegistrationView = iRegistrationView;
        this.context = context;
    }

    @Override
    public void launchRegisterAPI(ActivityRegistrationBinding binding) {
        if (areFieldsValid(binding)) {
            //write your business logic for api call
           iRegistrationView.showAPIRegisterSuccess();
        }
    }

    @Override
    public boolean areFieldsValid(ActivityRegistrationBinding binding) {

        // write your validation business logic
        return true;
    }

}
