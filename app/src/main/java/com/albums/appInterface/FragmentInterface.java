package com.albums.appInterface;

import android.support.v4.app.Fragment;

public interface FragmentInterface {

    void addFragment(Fragment fragment);
    boolean checkNetworkConnection();
    void hideKeyboard();
    void setActivityInterfaceFromFragment(ActivityInterface activityInterface);
}
