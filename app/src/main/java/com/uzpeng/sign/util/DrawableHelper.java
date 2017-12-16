package com.uzpeng.sign.util;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

import java.util.Random;

/**
 * @author serverliu on 2017/12/15.
 */

public class DrawableHelper {
  private static String[] candyColor={"#AEEC33", "#85B0FE", "#57EFA2", "#FFC157",
    "#FFC44E", "#FF9DD8", "#AA90FD", "#75E6E9","#70EB54", "#72E3E3", "#FF9391"};

  public static Drawable getRectangleDrawable(){
    GradientDrawable drawable = new GradientDrawable();
    drawable.setShape(GradientDrawable.RECTANGLE);
    drawable.setCornerRadius(3.0f);
    Random random = new Random();
    drawable.setColor(Color.parseColor(candyColor[random.nextInt(candyColor.length)]));

    return drawable;
  }
}
