package com.baliyaan.android.mvp.Adapters;

import android.content.Context;
import android.os.Bundle;

import com.baliyaan.android.mvp.Interfaces.BaseMVPNavigator;
import com.baliyaan.android.mvp.Interfaces.BaseMVPPort;
import com.baliyaan.android.mvp.Interfaces.BaseMVPPresenter;
import com.baliyaan.android.mvp.Interfaces.BaseMVPView;

/**
 * Created by Pulkit Singh on 7/1/2017.
 */

public class MVPViewPortAdapter<N extends BaseMVPNavigator,P extends BaseMVPPresenter> implements BaseMVPView<P>, BaseMVPPort {
    private N _navigator;
    protected P _presenter;

    protected MVPViewPortAdapter(N navigator){
        _navigator = navigator;
    }

    protected N navigator(){
        return _navigator;
    }

    protected P presenter() {
        return _presenter;
    }

    @Override
    public Context getContext() {
        return navigator().getContext();
    }

    // BaseMVPView implementation
    @Override
    public P bindPresenter(P presenter) {
        _presenter = presenter;
        return _presenter;
    }

    // BaseMVPPort implementation
    @Override
    public void onSaveState(Bundle state) {
        if(null != presenter())
            presenter().onSaveState(state);
    }

    @Override
    public void onRestoreState(Bundle state) {
        if(null != presenter())
            presenter().onRestoreState(state);
    }
}
