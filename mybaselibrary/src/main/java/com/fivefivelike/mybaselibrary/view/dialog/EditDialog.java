package com.fivefivelike.mybaselibrary.view.dialog;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.fivefivelike.mybaselibrary.R;


/**
 * Created by liugongce on 2016/12/28.
 */

public class EditDialog extends BaseDialog {
    TextView title;
    TextView content;
    TextView left;
    TextView right;
    OnEditListener onEditListener;

    public EditDialog(Activity context, OnEditListener onEditListener) {
        super(context);
        this.onEditListener = onEditListener;
    }

    @Override
    protected int getLayout() {
        return R.layout.dialog_edit;
    }

    @Override
    protected void startInit() {
        title = getView(R.id.title);
        content = getView(R.id.content);
        left = getView(R.id.left);
        right = getView(R.id.right);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        setWindow(20, 0, 20, 0);
        setShowLoaction(Loction.CENTER);
    }

    public EditDialog setShowTitle(String titleStr) {
        title.setText(titleStr);
        return this;
    }

    public EditDialog setIsCancel(boolean isCancelAble) {
        setCancelable(isCancelAble);
        setCanceledOnTouchOutside(isCancelAble);
        return this;
    }

    public EditDialog setShowContent(String contentStr) {
        content.setText(contentStr);
        return this;
    }

    public EditDialog setLeft(String leftStr) {
        left.setText(leftStr);
        return this;
    }

    public EditDialog setRight(String rightStr) {
        right.setText(rightStr);
        return this;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.left) {
            dismiss();
            onEditListener.onClickLeft();
        } else if (view.getId() == R.id.right) {
            dismiss();
            onEditListener.onClickRight();
        }
    }

    public interface OnEditListener {
        void onClickLeft();

        void onClickRight();
    }
}
