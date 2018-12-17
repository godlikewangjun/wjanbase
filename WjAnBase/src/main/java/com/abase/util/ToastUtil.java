package com.abase.util;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;

import com.abase.view.weight.StyleableToast;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;


/**
 * toast 工具类
 * @author Admin
 * @version 1.0
 * @date 2018/8/2
 */
public class ToastUtil {
    private static SoftReference<StyleableToast.Builder> toast;// 提示
    private static boolean isShowDeBug = true;// 提示
    private static final int SHOWTOAST = 3000;
    /**
     * 显示toast
     *
     * @param context activity
     * @param text    显示的内容
     */
    public static void showTip(final Context context, final String text) {
        if (toast != null &&  toast.get()!=null) {
            toast.get().text(text);
        } else {
            toast =new SoftReference<>(cusBuild(context).text(text));
        }
        toast.get().show();
    }

    /**
     * 显示toast
     *
     * @param context activity
     * @param text    显示的内容
     */
    public static void showTipOne(final Context context, final String text, final int gravity) {
        if (toast != null &&  toast.get()!=null) {
            toast.get().text(text);
        } else {
            toast =new SoftReference<>(cusBuild(context).text(text).gravity(gravity));
        }
        toast.get().show();
    }

    /**
     * 设置弹出框样式
     */
    public static StyleableToast.Builder setStyle(){
        if (toast != null &&  toast.get()!=null) {
            return toast.get();
        }
        return null;
    }
    /**
     * 返回公共的构建参数
     * @param context
     * @return
     */
    private static StyleableToast.Builder cusBuild(final Context context){
       return new StyleableToast.Builder(context)
               .textColor(context.getResources().getColor(android.R.color.white))
                .backgroundColor(Color.parseColor("#507DFE"));
    }
}
