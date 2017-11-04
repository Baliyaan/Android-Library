package com.baliyaan.android.mvp.Interfaces;

/**
 * Created by Pulkit Singh on 7/2/2017.
 */

public interface BaseMVPView<P extends BaseMVPPresenter> {
    P bindPresenter(P presenter);
}
