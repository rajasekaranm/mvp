package ocs.com.mvp.ui.connection;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import ocs.com.mvp.ui.connection.contractor.IContractorRegistration;
import ocs.com.mvp.ui.connection.presenter.PresenterRegistration;
import ocs.com.mvp.databinding.ActivityRegistrationBinding;
import ocs.com.mvp.R;

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
            presenterMain.launchRegisterAPI(binding);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
