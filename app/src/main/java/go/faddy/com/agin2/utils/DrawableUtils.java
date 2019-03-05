package go.faddy.com.agin2.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;

import go.faddy.com.agin2.R;

import com.applandeo.materialcalendarview.CalendarUtils;


public final class DrawableUtils {

    public static Drawable getCircleDrawableWithText(Context context, String string) {
        Drawable background = ContextCompat.getDrawable(context, R.drawable.sample_circle);
        Drawable text = CalendarUtils.getDrawableText(context, string, null, android.R.color.white, 12);

        Drawable[] layers = {background, text};
        return new LayerDrawable(layers);
    }

    public static Drawable getThreeDots(Context context) {
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.sample_three_icons);

        //Add padding to too large icon
        return new InsetDrawable(drawable, 100, 0, 100, 0);
    }

    private DrawableUtils() {
    }
}
