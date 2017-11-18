package ocs.com.mvp.ui.home.contractor;


import java.util.ArrayList;

public interface IContractorHome {

    interface IHomePresenter {

        ArrayList<String> getImages();

    }

    interface IHomeView {
        void initToolbar();

        void initUI();

        void loadData();

        void addAdapter();

    }
}
