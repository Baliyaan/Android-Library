package com.baliyaan.android.mvp.Interfaces;

import android.content.Context;
import android.os.Bundle;

/**
 * Created by Pulkit Singh on 11/5/2017.
 */

public interface BaseMVPNavigator {
    Context getContext();

    /**
     * Returns instance of the required object,
     * usually one of those whose same instance is to be used everywhere.
     * eg. Firebase etc.
     * @param className
     * @param params
     * @return
     */
    Object getInstanceOf(String className, Bundle params);
}
