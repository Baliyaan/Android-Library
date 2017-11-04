package com.baliyaan.android.mvp.Demo;

import com.baliyaan.android.mvp.Interfaces.BaseMVPPort;
import com.baliyaan.android.mvp.Interfaces.BaseMVPPresenter;
import com.baliyaan.android.mvp.Interfaces.BaseMVPView;

/**
 * Created by Pulkit Singh on 11/4/2017.
 */

public class DemoMVPContract {
    interface View extends BaseMVPView<Presenter> {
        void makeViewSomething();
    }

    interface Presenter extends BaseMVPPresenter {
        void makePresenterSomething();
    }

    interface Navigator {
        void makeNavigatorSomething();
    }

    interface Port extends BaseMVPPort {
        void makePortSomething();
    }
}
