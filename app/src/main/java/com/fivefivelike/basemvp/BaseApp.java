package com.fivefivelike.basemvp;

import android.app.Application;

import com.fivefivelike.mybaselibrary.utils.GlobleContext;
import com.yanzhenjie.nohttp.NoHttp;

/**
 * Created by liugongce on 2017/7/6.
 */
public class BaseApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        NoHttp.initialize(this);
        GlobleContext.init(this);
    }
}
