package ocs.com.mvp.ui.home.presenter;


import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;

import ocs.com.mvp.ui.home.contractor.IContractorHome;
import ocs.com.mvp.utils.ImagesSample;

public class PresenterHome implements IContractorHome.IHomePresenter {
    Context context;
    IContractorHome.IHomeView iHomeView;

    public PresenterHome(Context context, IContractorHome.IHomeView iHomeView) {
        this.context = context;
        this.iHomeView = iHomeView;
    }

    @Override
    public ArrayList<String> getImages() {
        ArrayList<String> images = new ArrayList<>();
        images.addAll(Arrays.asList(ImagesSample.images));
        return images;
    }
}
