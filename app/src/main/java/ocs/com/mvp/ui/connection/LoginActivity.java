package ocs.com.mvp.ui.connection;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import ocs.com.mvp.R;
import ocs.com.mvp.databinding.ActivityLoginBinding;
import ocs.com.mvp.ui.connection.contractor.IContractorLogin;
import ocs.com.mvp.ui.connection.presenter.PresenterLogin;
import ocs.com.mvp.ui.home.HomeActivity;
import ocs.com.mvp.utils.InternetConnection;
import ocs.com.mvp.webservice.requests.RequestLogin;

public class LoginActivity extends AppCompatActivity implements IContractorLogin.ILoginView {
    ActivityLoginBinding binding;
    PresenterLogin presenterLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        presenterLogin = new PresenterLogin(this, this);
        initToolbar();

        binding.btLoginConfirm.setOnClickListener(View -> {
            if (areFieldsValid() && InternetConnection.isConnected(LoginActivity.this)){
                binding.btLoginConfirm.setEnabled(false);
                binding.btLoginConfirm.setBackgroundColor(ContextCompat.getColor(LoginActivity.this, R.color.colorAccent));
                presenterLogin.launchLoginAPI(getLoginRequest());
            }
        });
        binding.btLoginCreateAcount.setOnClickListener(View -> {
            startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
        });
    }

    @Override
    public void onAPILoginSuccess() {
        Toast.makeText(this, R.string.alert_api_succes, Toast.LENGTH_SHORT).show();
        openHome();
    }

    @Override
    public void onAPILoginFailed(String reason) {
        Toast.makeText(this, "" + reason, Toast.LENGTH_SHORT).show();
        openHome();
    }

    @Override
    public void initToolbar() {
        setSupportActionBar(binding.tbLogin);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean areFieldsValid() {
        View view = null;
        boolean response = true;
        String email = binding.etLoginEmail.getText().toString().trim();
        String password = binding.etLoginPassword.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            response = false;
            view = binding.etLoginEmail;
            binding.etLoginEmail.setError(getString(R.string.alert_field_required));
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            response = false;
            view = binding.etLoginEmail;
            binding.etLoginEmail.setError(getString(R.string.alert_field_invalid_email));
        } else if (TextUtils.isEmpty(password)) {
            response = false;
            view = binding.etLoginPassword;
            binding.etLoginPassword.setError(getString(R.string.alert_field_required));
        }
        if (!response)
            view.requestFocus();

        return response;
    }

    @Override
    public RequestLogin getLoginRequest() {
        RequestLogin requestLogin = new RequestLogin();
        requestLogin.setEmail(binding.etLoginEmail.getText().toString());
        requestLogin.setPassword(binding.etLoginPassword.getText().toString());
        return requestLogin;
    }

    @Override
    public void openHome() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
