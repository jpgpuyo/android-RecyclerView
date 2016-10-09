package com.example.android.common.navigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.android.recyclerview.R;
import com.example.android.recyclerview.google.GoogleFragment;
import com.example.android.recyclerview.groupie.GroupieFragment;
import com.example.android.recyclerview.renderers.ui.RenderersFragment;

public class Navigator {

    public Navigator() {
    }

    public void loadGoogleFragment(FragmentManager fragmentManager) {
        loadFragment(fragmentManager, new GoogleFragment());
    }

    public void loadRenderersFragment(FragmentManager fragmentManager) {
        loadFragment(fragmentManager, new RenderersFragment());
    }

    public void loadGroupieFragment(FragmentManager fragmentManager) {
        loadFragment(fragmentManager, new GroupieFragment());
    }

    private void loadFragment(FragmentManager fragmentManager, Fragment fragment) {
        fragmentManager.beginTransaction().replace(R.id.sample_content_fragment, fragment).
                commitAllowingStateLoss();
    }
}
