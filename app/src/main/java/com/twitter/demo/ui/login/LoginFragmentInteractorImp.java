package com.twitter.demo.ui.login;

import android.content.Context;

import com.twitter.demo.utilities.SharedPrefUtilis;
import com.twitter.sdk.android.core.models.User;

import java.lang.ref.WeakReference;

/**
 * Created by Bassem Qoulta (Deda) on  7/10/17.
 * Bassem.Qoulta@gmail.com
 * Basem083926@feng.bu.edu.eg
 * +201225361630
 */

public class LoginFragmentInteractorImp  implements LoginFragmentInteractor{

    private WeakReference<Context> weakReference;

    public LoginFragmentInteractorImp(Context context) {
        this.weakReference = new WeakReference<Context>(context);
    }

    @Override
    public void saveUserAccountInfo(User user) {
        SharedPrefUtilis.saveUserAccountInfo(weakReference.get(), user);
    }
}
