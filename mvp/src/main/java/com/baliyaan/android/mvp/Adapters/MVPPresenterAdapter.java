package com.baliyaan.android.mvp.Adapters;

import android.os.Bundle;

import com.baliyaan.android.mvp.Interfaces.BaseMVPPresenter;
import com.baliyaan.android.mvp.Interfaces.BaseMVPView;

/**
 * Created by Pulkit Singh on 7/1/2017.
 */

public class MVPPresenterAdapter<T extends BaseMVPView> implements BaseMVPPresenter{

    private T _view = null;

    protected MVPPresenterAdapter(T view){
        _view = view;
    }

    protected T view(){
        return _view;
    }

    // BaseMVPPresenter implementation

    @Override
    public void onSaveState(Bundle state) {
        //Bundle bundle = null;
        //setState(bundle);
    }

    @Override
    public void onRestoreState(Bundle state) {
        //Bundle bundle = getState();
        //bundle.getString("key1");
    }
}
