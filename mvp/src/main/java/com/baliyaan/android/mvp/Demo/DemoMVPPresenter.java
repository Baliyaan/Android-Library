package com.baliyaan.android.mvp.Demo;


import com.baliyaan.android.mvp.Adapters.MVPPresenterAdapter;

/**
 * Created by Pulkit Singh on 11/4/2017.
 */

public class DemoMVPPresenter
        extends MVPPresenterAdapter<DemoMVPContract.View>
        implements DemoMVPContract.Presenter {

    protected DemoMVPPresenter(DemoMVPContract.View view) {
        super(view);

        view().makeViewSomething();
    }

    @Override
    public void makePresenterSomething() {
    }
}
