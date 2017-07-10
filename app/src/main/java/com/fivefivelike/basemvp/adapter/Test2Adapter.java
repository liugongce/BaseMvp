package com.fivefivelike.basemvp.adapter;

import android.content.Context;
import android.widget.TextView;

import com.fivefivelike.basemvp.R;
import com.fivefivelike.basemvp.entity.NewsEntity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by liugongce on 2017/7/10.
 */

public class Test2Adapter extends CommonAdapter<NewsEntity.ListBean> {
    private TextView tvName;
    public Test2Adapter(Context context,  List<NewsEntity.ListBean> datas) {
        super(context, R.layout.adapter_test1, datas);
    }

    @Override
    protected void convert(ViewHolder holder, NewsEntity.ListBean listBean, int position) {
        tvName=holder.getView(R.id.tv_name);
        tvName.setText(listBean.getName());
    }
}
