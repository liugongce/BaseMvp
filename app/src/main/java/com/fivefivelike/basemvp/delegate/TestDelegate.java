package com.fivefivelike.basemvp.delegate;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fivefivelike.basemvp.R;
import com.fivefivelike.mybaselibrary.base.BaseDelegate;


/**
 * Created by liugongce on 2017/7/3.
 */

public class TestDelegate extends BaseDelegate {
    public  ViewHolder viewHolder;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_test1;
    }

    @Override
    public void initView() {
        viewHolder=new ViewHolder(getRootView());
    }

    public ViewHolder getViewHolder() {
        return viewHolder;
    }

    public void setData(String data){
        viewHolder.tv_content.setText(data);
    }
    public static class ViewHolder {
        public View rootView;
        public Button button;
        public TextView tv_content;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.button = (Button) rootView.findViewById(R.id.button);
            this.tv_content = (TextView) rootView.findViewById(R.id.tv_content);
        }

    }
}
