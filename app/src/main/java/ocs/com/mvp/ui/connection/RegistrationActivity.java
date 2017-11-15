package ocs.com.mvp.ui.connection;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import ocs.com.mvp.ui.connection.contractor.IContractorRegistration;
import ocs.com.mvp.ui.connection.presenter.PresenterRegistration;
import ocs.com.mvp.databinding.ActivityRegistrationBinding;
import ocs.com.mvp.R;
import ocs.com.mvp.webservice.requests.RequestRegister;

public class RegistrationActivity extends AppCompatActivity implements IContractorRegistration.IRegistrationView {

    PresenterRegistration presenterMain;
    ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration);
        presenterMain = new PresenterRegistration(this, this);
        initToolbar();

        binding.btRegister.setOnClickListener(View -> {
            presenterMain.launchRegisterAPI(getRequestRegister());
        });
    }


    @Override
    public void onAPIRegisterSuccess() {
        Toast.makeText(this, "Succes", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAPIRegisterFailed(String reason) {
        Toast.makeText(this, "" + reason, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void initToolbar() {
        setSupportActionBar(binding.tbRegistration);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean areFieldsValid() {
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
    public RequestRegister getRequestRegister() {
        RequestRegister requestRegister = new RequestRegister();
        requestRegister.setFirstName(binding.etFirstName.getText().toString());
        requestRegister.setLastName(binding.etLastName.getText().toString());
        requestRegister.setEmail(binding.etEmail.getText().toString());
        requestRegister.setPassword(binding.etPassword.getText().toString());
        requestRegister.setConfirmPassword(binding.etConfPassword.getText().toString());
        return requestRegister;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
