package ocs.com.mvp.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;



public class InternetConnection {

    public static boolean isConnected(Activity activity) {
        ConnectivityManager cm =
                (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean return_status = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (!return_status) {
        }
        return return_status;
    }



}
