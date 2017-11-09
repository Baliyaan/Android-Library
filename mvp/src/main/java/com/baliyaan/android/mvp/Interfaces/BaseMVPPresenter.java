package com.baliyaan.android.mvp.Interfaces;

import android.os.Bundle;

/**
 * Created by Pulkit Singh on 7/2/2017.
 */

public interface BaseMVPPresenter {
    void onSaveState(Bundle state);
    void onRestoreState(Bundle state);
}
