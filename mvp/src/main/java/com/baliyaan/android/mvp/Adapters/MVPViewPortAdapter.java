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
    public void onSaveState() {
        if(null != presenter())
            presenter().onSaveState();
    }

    @Override
    public void onResumeState() {
        if(null != presenter())
            presenter().onResumeState();
    }

    @Override
    public Bundle getState() {
        return presenter().getState();
    }

    @Override
    public void setState(Bundle state) {
        presenter().setState(state);
    }
}
