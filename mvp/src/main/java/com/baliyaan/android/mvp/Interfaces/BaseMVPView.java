package com.baliyaan.android.mvp.Interfaces;

import android.content.Context;
import android.os.Bundle;

/**
 * Created by Pulkit Singh on 7/2/2017.
 */

public interface BaseMVPView<P extends BaseMVPPresenter> {
    P bindPresenter(P presenter);

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
