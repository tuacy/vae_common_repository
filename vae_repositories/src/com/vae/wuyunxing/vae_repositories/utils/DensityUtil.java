package com.vae.wuyunxing.vae_repositories.utils;

import android.content.Context;

public class DensityUtil {

    /**
     * dip(dp) to px
     * @param context : context
     * @param dpValue : dip
     * @return px
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px to dip(dip)
     * @param context : context
     * @param pxValue : px
     * @return : dip(dp)
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp to px
     * @param context : context
     * @param spValue : sp
     * @return : px
     */
    public static int sp2px(Context context, float spValue) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * scale);
    }

    /**
     * px to so
     * @param context : context
     * @param pxValue : px
     * @return : sp
     */
    public static int px2sp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / scale);
    }


}
