package com.fivefivelike.mybaselibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.fivefivelike.mybaselibrary.mvp.databind.IDataBind;


/**
 * Created by liugongce on 2017/7/3.
 */

public abstract class BaseDataBindFragment<T extends BaseDelegate,D extends IDataBind> extends BaseFragment<T> {
    protected D binder;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binder = getDataBinder(viewDelegate);
    }

    public abstract D getDataBinder(T viewDelegate);



}
