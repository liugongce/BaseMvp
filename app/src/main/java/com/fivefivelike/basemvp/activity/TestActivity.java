package com.fivefivelike.basemvp.activity;

import android.view.View;

import com.fivefivelike.basemvp.R;
import com.fivefivelike.basemvp.delegate.TestDelegate;
import com.fivefivelike.basemvp.model.TestDataBinder;
import com.fivefivelike.mybaselibrary.base.BaseDataBindActivity;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;

/**
 * Created by liugongce on 2017/7/10.
 */

public class TestActivity extends BaseDataBindActivity<TestDelegate, TestDataBinder> {


    @Override
    protected Class<TestDelegate> getDelegateClass() {
        return TestDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("测试网络请求"));
        viewDelegate.setOnClickListener(this, R.id.button, R.id.button1, R.id.button2);
    }

    @Override
    protected void onServiceSuccess(String data, String info, int status, int requestCode) {
        viewDelegate.setData(data);
    }

    @Override
    public TestDataBinder getDataBinder(TestDelegate viewDelegate) {
        return new TestDataBinder(viewDelegate);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                addRequest(binder.getData(this,String.valueOf(1),String.valueOf(20)));
                break;
            case R.id.button1:
                addRequest(binder.getData1());
                break;
            case R.id.button2:
                binder.getData2();
                break;
        }
    }
}
