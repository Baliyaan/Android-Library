package com.baliyaan.android.mvp.Demo;

import com.baliyaan.android.mvp.Adapters.MVPViewPortAdapter;

/**
 * Created by Pulkit Singh on 11/4/2017.
 */

public class DemoMVPViewPort
        extends MVPViewPortAdapter<DemoMVPContract.Navigator,DemoMVPContract.Presenter>
        implements DemoMVPContract.View, DemoMVPContract.Port {

    protected DemoMVPViewPort(DemoMVPContract.Navigator navigator) {
        super(navigator);
        super.bindPresenter(new DemoMVPPresenter(this));

        presenter().makePresenterSomething();
        navigator().makeNavigatorSomething();
    }

    @Override
    public void makeViewSomething() {
    }

    @Override
    public void makePortSomething() {
    }
}
