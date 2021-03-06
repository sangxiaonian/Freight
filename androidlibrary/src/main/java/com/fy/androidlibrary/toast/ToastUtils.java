package com.fy.androidlibrary.toast;

import android.content.Context;
import android.view.View;


public class ToastUtils implements IToast {

    private   Context mContext;

    IToast toast;
    IToast toastSuccess;
    IToast toastCenter;
    IToast toastNormal;

    public static class InnerToast {
        public static ToastUtils toast = new ToastUtils();
    }

    public enum ToastType {
        SUCCESS, CENTER, NORMAL
    }


    public void init(Context context) {
        mContext = context;
        toastSuccess = new ToastSuccess(context);
        toastCenter = new ToastCenter(context);
        toastNormal = new ToastNormal(context);
        toast = toastNormal;
    }


    public static ToastUtils getInstance() {
        return InnerToast.toast;
    }


    public ToastUtils makeToast(ToastType type) {
        switch (type) {
            case SUCCESS:
                toast = toastSuccess;
                break;
            case CENTER:
                toast = toastCenter;
                break;
            case NORMAL:
            default:
                toast = toastNormal;
                break;
        }
        return this;
    }

    private ToastUtils() {
    }


    @Override
    public void setShowTime(int time) {
        toast.setShowTime(time);
    }

    /**
     * 设置不同的View
     *
     * @param view
     */
    @Override
    public void setView(View view) {
        toast.setView(view);
    }

    /**
     * 设置显示的文字
     *
     * @param text
     */
    @Override
    public void setText(String text) {
        toast.setText(text);
    }

    @Override
    public void show(String msg) {
        toast.show(msg);
        makeToast(ToastType.NORMAL);
    }

    @Override
    public void show(int msg) {
        toast.show(msg);
        makeToast(ToastType.NORMAL);
    }

    @Override
    public void show() {
        toast.show();
        makeToast(ToastType.NORMAL);
    }

    @Override
    public void show(Context context, int msg) {
        toast.show(context, msg);
        makeToast(ToastType.NORMAL);
    }

    @Override
    public void show(Context context, String msg) {
        toast.show(context, msg);
        makeToast(ToastType.NORMAL);
    }


}