package ocs.com.mvp.ui.connection.presenter;
/*
 * Created by "Appsolute dev" on 11/4/2017.
 */

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;


import ocs.com.mvp.databinding.ActivityRegistrationBinding;
import ocs.com.mvp.ui.connection.contractor.IContractorRegistration;

public class PresenterRegistration implements IContractorRegistration.IRegistrationPresenter {
    private IContractorRegistration.IRegistrationView iMainView;
    private Context context;

    public PresenterRegistration(IContractorRegistration.IRegistrationView iMainView, Context context) {
        this.iMainView = iMainView;
        this.context = context;
    }

    @Override
    public void launchRegisterAPI(ActivityRegistrationBinding binding) {
        if (areFieldsValid(binding)) {
            //write your business logic for api call
           iMainView.showAPIRegisterSuccess();
        }
    }

    @Override
    public boolean areFieldsValid(ActivityRegistrationBinding binding) {

        // write your validation business logic
        return true;
    }

}
