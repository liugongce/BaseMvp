package com.fivefivelike.basemvp.activity;

import android.support.v7.widget.LinearLayoutManager;

import com.fivefivelike.basemvp.adapter.Test2Adapter;
import com.fivefivelike.basemvp.delegate.Test2Delegate;
import com.fivefivelike.basemvp.entity.NewsEntity;
import com.fivefivelike.basemvp.model.Test2DataBinder;
import com.fivefivelike.mybaselibrary.base.BasePullActivity;
import com.fivefivelike.mybaselibrary.entity.ToolbarBuilder;
import com.fivefivelike.mybaselibrary.utils.GsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liugongce on 2017/7/10.
 */

public class Test2Activity extends BasePullActivity<Test2Delegate, Test2DataBinder> {
    private Test2Adapter adapter;
    private List<NewsEntity.ListBean> list;

    @Override
    public Test2DataBinder getDataBinder(Test2Delegate viewDelegate) {
        return new Test2DataBinder(viewDelegate);
    }

    @Override
    protected Class<Test2Delegate> getDelegateClass() {
        return Test2Delegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        initToolbar(new ToolbarBuilder().setTitle("新闻列表"));
        initRv();
    }

    private void initRv() {
        list = new ArrayList<>();
        adapter = new Test2Adapter(this, list);
        initRecycleViewPull(adapter, new LinearLayoutManager(this));
        refreshData();
    }

    @Override
    protected void refreshData() {
        binder.getData(this, viewDelegate.page + "", viewDelegate.pagesize + "");
    }

    @Override
    protected void onServiceSuccess(String data, String info, int status, int requestCode) {
        NewsEntity newsEntity = GsonUtil.getInstance().json2Bean(data, NewsEntity.class);
        getDataBack(list, newsEntity.getList(), adapter);
    }
}
