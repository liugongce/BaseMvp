package com.fivefivelike.basemvp.model;

import com.fivefivelike.basemvp.delegate.TestDelegate;
import com.fivefivelike.basemvp.utils.Httpurl;
import com.fivefivelike.mybaselibrary.base.BaseDataBind;
import com.fivefivelike.mybaselibrary.http.HttpRequest;
import com.fivefivelike.mybaselibrary.http.RequestCallBackImpl;
import com.fivefivelike.mybaselibrary.http.RequestCallback;
import com.yanzhenjie.nohttp.rest.CacheMode;

import rx.Subscription;

/**
 * Created by liugongce on 2017/7/3.
 */

public class TestDataBinder extends BaseDataBind<TestDelegate> {

    public TestDataBinder(TestDelegate viewDelegate) {
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

    public Subscription getData1() {
        getBaseMap();
        baseMap.put("pagesize", "20");
        baseMap.put("page", "1");
        baseMap.put("cid", "136");
        return new HttpRequest.Builder()
                .setRequestCode(0x234)
                .setRequestUrl(Httpurl.NEWS_INDEX)
                .setRequestName("测试api")
                .setRequestObj(baseMap)
                .setShowDialog(true)
                .setCacheMode(CacheMode.ONLY_REQUEST_NETWORK)
                .setDialog(viewDelegate.getNetConnectDialog())
                .setRequestCallback(new RequestCallBackImpl() {
                    @Override
                    protected void onServiceSuccess(String data, String info, int status, int requestCode) {
                        viewDelegate.setData(data);
                    }
                })
                .build()
                .RxSendRequest();
    }

    public void getData2() {
        getBaseMap();
        baseMap.put("pagesize", "20");
        baseMap.put("page", "1");
        baseMap.put("cid", "136");
        new HttpRequest.Builder()
                .setRequestCode(0x345)
                .setRequestUrl(Httpurl.NEWS_INDEX)
                .setRequestName("测试api")
                .setRequestObj(baseMap)
                .setCacheMode(CacheMode.ONLY_REQUEST_NETWORK)
                .setShowDialog(true)
                .setDialog(viewDelegate.getNetConnectDialog())
                .setRequestCallback(new RequestCallBackImpl() {
                    @Override
                    protected void onServiceSuccess(String data, String info, int status, int requestCode) {
                        viewDelegate.setData(data);
                    }
                    @Override
                    protected void onServiceError(String data, String info, int status, int requestCode) {
                        super.onServiceError(data, info, status, requestCode);
                        viewDelegate.setData(data);
                    }
                })
                .build()
                .sendRequest();
    }

}
