package com.example.playground;

import android.app.Application;
import androidx.annotation.ArrayRes;
import androidx.annotation.PluralsRes;
import androidx.annotation.StringRes;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class StringProvider {

    private final Application application;

    @Inject
    public StringProvider(Application application) {
        this.application = application;
    }

    public String getString(@StringRes int resId) {
        return application.getString(resId);
    }

    public String getString(@StringRes int resId, Object... formatArgs) {
        return application.getString(resId, formatArgs);
    }

    public String getQuantityString(@PluralsRes int resId, int quantity, Object... formatArgs) {
        return application.getResources().getQuantityString(resId, quantity, formatArgs);
    }

    public String[] getStringArray(@ArrayRes int resId) {
        return application.getResources().getStringArray(resId);
    }
}
