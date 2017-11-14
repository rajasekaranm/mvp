package ocs.com.mvp.ui.connection.presenter;


import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import ocs.com.mvp.databinding.ActivityRegistrationBinding;
import ocs.com.mvp.models.User;
import ocs.com.mvp.ui.connection.contractor.IContractorRegistration;
import ocs.com.mvp.webservice.APIClient;
import ocs.com.mvp.webservice.APIConnection;
import ocs.com.mvp.webservice.requests.RequestRegister;
import ocs.com.mvp.webservice.responses.ResponseRegistration;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterRegistration implements IContractorRegistration.IRegistrationPresenter {
    private IContractorRegistration.IRegistrationView iRegistrationView;
    private Context context;

    public PresenterRegistration(IContractorRegistration.IRegistrationView iRegistrationView, Context context) {
        this.iRegistrationView = iRegistrationView;
        this.context = context;
    }

    //restrofit api call
    @Override
    public void launchRegisterAPI(ActivityRegistrationBinding binding) {
        if (areFieldsValid(binding)) {
            APIConnection apiConnection = APIClient.getClient().create(APIConnection.class);
            Call<ResponseRegistration> call = apiConnection.register(getRequestRegister(binding));
            call.enqueue(new Callback<ResponseRegistration>() {
                @Override
                public void onResponse(Call<ResponseRegistration> call, Response<ResponseRegistration> response) {
                    if (response.body() != null) {
                        onSaveUserIntoDB(response.body().getUser());
                        iRegistrationView.onAPIRegisterSuccess();
                    } else {
                        iRegistrationView.onAPIRegisterFailed("Invalid response");
                    }
                }

                @Override
                public void onFailure(Call<ResponseRegistration> call, Throwable t) {
                    iRegistrationView.onAPIRegisterFailed("Failed");
                }
            });

        }
    }

    /*
    Save user data into database
     */
    @Override
    public void onSaveUserIntoDB(User user) {

    }

    /*
    validation for registration fields
     */
    @Override
    public boolean areFieldsValid(ActivityRegistrationBinding binding) {

        boolean response = true;
        View view = null;

        String firstName = binding.etFirstName.getText().toString();
        String lastName = binding.etLastName.getText().toString();
        String email = binding.etEmail.getText().toString();
        String password = binding.etPassword.getText().toString();
        String confirmPassword = binding.etConfPassword.getText().toString();
        if (TextUtils.isEmpty(firstName)) {
            response = false;
            view = binding.etFirstName;
            binding.etFirstName.setError("required");
        } else if (TextUtils.isEmpty(lastName)) {
            response = false;
            view = binding.etLastName;
            binding.etLastName.setError("required");
        } else if (TextUtils.isEmpty(email)) {
            response = false;
            view = binding.etEmail;
            binding.etEmail.setError("required");
        } else if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            response = false;
            view = binding.etEmail;
            binding.etEmail.setError("invalid email");
        } else if (TextUtils.isEmpty(password)) {
            response = false;
            view = binding.etPassword;
            binding.etPassword.setError("required");
        } else if (!password.equalsIgnoreCase(confirmPassword)) {
            response = false;
            view = binding.etConfPassword;
            binding.etConfPassword.setError("both passwords are not same");
        }

        if (!response)
            view.requestFocus();

        return response;
    }

    /*
    create request object for registration
     */
    @Override
    public RequestRegister getRequestRegister(ActivityRegistrationBinding binding) {
        RequestRegister requestRegister = new RequestRegister();
        requestRegister.setFirstName(binding.etFirstName.getText().toString());
        requestRegister.setLastName(binding.etLastName.getText().toString());
        requestRegister.setEmail(binding.etEmail.getText().toString());
        requestRegister.setPassword(binding.etPassword.getText().toString());
        requestRegister.setConfirmPassword(binding.etConfPassword.getText().toString());
        return requestRegister;
    }


}
