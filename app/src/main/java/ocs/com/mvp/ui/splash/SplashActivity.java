package ocs.com.mvp.ui.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ocs.com.mvp.R;
import ocs.com.mvp.ui.connection.RegistrationActivity;

public class SplashActivity extends AppCompatActivity {
    private boolean isAppKilled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isAppKilled) {
                    startActivity(new Intent(SplashActivity.this, RegistrationActivity.class));
                    finish();
                }
            }
        }, 3000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        isAppKilled = true;
    }
}
