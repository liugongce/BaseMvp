package com.fivefivelike.basemvp.activity;

import android.view.View;

import com.fivefivelike.basemvp.R;
import com.fivefivelike.basemvp.delegate.MainDelegate;
import com.fivefivelike.mybaselibrary.base.BaseActivity;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;


public class MainActivity extends BaseActivity<MainDelegate>{

    @Override
    protected Class<MainDelegate> getDelegateClass() {
        return MainDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("首页"));
        viewDelegate.setOnClickListener(this, R.id.button, R.id.button2,R.id.button3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:

                break;
            case R.id.button2:
                gotoActivty(new TestActivity());
                break;
            case R.id.button3:
                gotoActivty(new Test2Activity());
                break;
        }
    }
}
