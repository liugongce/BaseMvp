package com.fivefivelike.mybaselibrary.view.popupWindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by liugongce on 2016/11/11.
 */

public abstract class BasePopupWindow extends PopupWindow {
    protected View v;
    protected Context context;
    BasePopupWindow(Context context){
        this.context=context;
        v = LayoutInflater.from(context).inflate(getLayoutId(),
                null);
        setContentView(v);
        setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        setFocusable(true);
        setOutsideTouchable(true);
        // 刷新状态
        update();
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable();
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        setBackgroundDrawable(dw);
        initView();
    }
    public <E extends View> E findViewById(int resId) {
        return (E) v.findViewById(resId);
    }
    public abstract int getLayoutId();

    public abstract void initView();
}
