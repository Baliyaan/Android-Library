package com.baliyaan.android.mvp.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.baliyaan.android.mvp.Interfaces.BaseMVPNavigator;
import com.baliyaan.android.mvp.Interfaces.BaseMVPPort;
import com.baliyaan.android.mvp.Interfaces.BaseMVPPresenter;
import com.baliyaan.android.mvp.Interfaces.BaseMVPView;

/**
 * Created by Pulkit Singh on 7/1/2017.
 */

public class MVPViewPortAdapter<N extends BaseMVPNavigator,P extends BaseMVPPresenter> implements BaseMVPView<P>, BaseMVPPort {
    private N _navigator;
    private P _presenter;
    private View _view;

    protected MVPViewPortAdapter(N navigator, View view){
        _navigator = navigator;
        _view = view;
    }

    protected N navigator(){
        return _navigator;
    }

    protected P presenter() {
        return _presenter;
    }

    protected View view(){
        return _view;
    }


    /*BaseMVPView implementations*/
    @Override
    public P bindPresenter(P presenter) {
        _presenter = presenter;
        return _presenter;
    }

    @Override
    public Context getContext() {
        return navigator().getContext();
    }

    @Override
    public Object getInstanceOf(String className, Bundle params) {
        return null;
    }

    /*BaseMVPPort implementations*/
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

    @Override
    public void setVisibility(int visibility) {
        view().setVisibility(visibility);
    }
}
