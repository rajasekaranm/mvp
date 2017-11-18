package ocs.com.mvp.ui.home;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;

import ocs.com.mvp.R;
import ocs.com.mvp.databinding.ActivityHomeBinding;
import ocs.com.mvp.ui.home.adapter.AdapterHomeImages;
import ocs.com.mvp.ui.home.contractor.IContractorHome;
import ocs.com.mvp.ui.home.presenter.PresenterHome;

public class HomeActivity extends AppCompatActivity implements IContractorHome.IHomeView {

    private PresenterHome presenterHome;
    private ActivityHomeBinding binding;
    private AdapterHomeImages adapterHomeImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        presenterHome = new PresenterHome(this, this);
        initUI();
    }

    @Override
    public void initToolbar() {
        setSupportActionBar(binding.tbHome);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void initUI() {
        initToolbar();
        binding.rvHomeImages.setLayoutManager(new LinearLayoutManager(this));
        addAdapter();
        loadData();

    }

    @Override
    public void loadData() {
        adapterHomeImages.addImages(presenterHome.getImages());

    }

    @Override
    public void addAdapter() {
        adapterHomeImages = new AdapterHomeImages(this);
        binding.rvHomeImages.setAdapter(adapterHomeImages);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
