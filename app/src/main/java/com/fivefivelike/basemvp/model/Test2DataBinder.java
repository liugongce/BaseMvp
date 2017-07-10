package com.fivefivelike.basemvp.model;

import com.fivefivelike.basemvp.delegate.Test2Delegate;
import com.fivefivelike.basemvp.utils.Httpurl;
import com.fivefivelike.mybaselibrary.base.BaseDataBind;
import com.fivefivelike.mybaselibrary.http.HttpRequest;
import com.fivefivelike.mybaselibrary.http.RequestCallback;
import com.yanzhenjie.nohttp.rest.CacheMode;

import rx.Subscription;

/**
 * Created by liugongce on 2017/7/3.
 */

public class Test2DataBinder extends BaseDataBind<Test2Delegate> {

    public Test2DataBinder(Test2Delegate viewDelegate) {
        super(viewDelegate);
    }

    public Subscription getData(RequestCallback requestCallback,String page,String pagesize) {
        getBaseMap();
        baseMap.put("pagesize", pagesize);
        baseMap.put("page", page);
        baseMap.put("cid", "136");
        return new HttpRequest.Builder()
                .setRequestCode(0x123)
                .setRequestUrl(Httpurl.NEWS_INDEX)
                .setRequestName("测试api")
                .setRequestObj(baseMap)
                .setShowDialog(true)
                .setCacheMode(CacheMode.ONLY_REQUEST_NETWORK)
                .setDialog(viewDelegate.getNetConnectDialog())
                .setRequestCallback(requestCallback)
                .build()
                .RxSendRequest();
    }


}
