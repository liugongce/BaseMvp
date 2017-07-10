package com.fivefivelike.mybaselibrary.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class ActUtil {
    private static Stack<Activity> mActivityStack;
    private static ActUtil mActUtil;

    private ActUtil() {
    }

    /**
     * 单一实例
     */
    public static ActUtil getInstance() {
        if (mActUtil == null) {
            synchronized (ActUtil.class){
                if (mActUtil == null) {
                    mActUtil = new ActUtil();
                }
            }
        }
        return mActUtil;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (mActivityStack == null) {
            mActivityStack = new Stack<>();
        }
        mActivityStack.add(activity);
    }

    /**
     * 获取栈顶Activity（堆栈中最后一个压入的）
     */
    public Activity getTopActivity() {
        Activity activity = mActivityStack.lastElement();
        return activity;
    }

    /**
     * 结束栈顶Activity（堆栈中最后一个压入的）
     */
    public void killTopActivity() {
        Activity activity = mActivityStack.lastElement();
        killActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void killActivity(Activity activity) {
        if (activity != null) {
            mActivityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    public void finishActivity(Activity activity){
        if (activity != null) {
            mActivityStack.remove(activity);
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void killActivity(Class<?> cls) {
        for (Activity activity : mActivityStack) {
            if (activity.getClass().equals(cls)) {
                killActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void killAllActivity(Activity activity) {
        List<Integer> list = new ArrayList<>();
        int size1 = mActivityStack.size();
        for (int i = 0; i < size1; i++) {
            if (null != mActivityStack.get(i)) {
                if (activity != null && activity.getClass().getName().equals(mActivityStack.get(i).getClass().getName())) {
                    continue;
                } else {
                    mActivityStack.get(i).finish();
                    list.add(i);
                }
            }
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mActivityStack.remove(list.get(i));
        }
    }

    /**
     * 结束所有Activity
     */
    public void killAllActivityWithout(List<String> activity) {
        for (int i = 0, size = mActivityStack.size(); i < size; i++) {
            if (null != mActivityStack.get(i)) {
                if (activity.contains(mActivityStack.get(i).getClass().getName())) {
                    continue;
                } else {
                    mActivityStack.get(i).finish();
                }
            }
        }
        mActivityStack.clear();
    }

    /**
     * 退出应用程序
     */
    @SuppressWarnings("deprecation")
    public void AppExit(Context context) {
        try {
            killAllActivity(null);
            ActivityManager activityMgr = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            // activityMgr.restartPackage(mContext.getPackageName());
            activityMgr.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
        }
    }



}
