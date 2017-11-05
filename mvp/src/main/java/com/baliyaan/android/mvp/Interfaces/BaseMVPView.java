package com.baliyaan.android.mvp.Interfaces;

import android.content.Context;

/**
 * Created by Pulkit Singh on 7/2/2017.
 */

public interface BaseMVPView<P extends BaseMVPPresenter> {
    Context getContext();
    P bindPresenter(P presenter);
}
