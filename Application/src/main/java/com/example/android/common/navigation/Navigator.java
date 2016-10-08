package com.example.android.common.navigation;

import android.support.v4.app.FragmentManager;

import com.example.android.recyclerview.google.GoogleFragment;

public class Navigator {

    public Navigator() {
    }

    public void goToGoogleFragment(FragmentManager fragmentManager, int idContainer) {
        fragmentManager.beginTransaction().replace(idContainer, new GoogleFragment()).
                commitAllowingStateLoss();
    }
}
