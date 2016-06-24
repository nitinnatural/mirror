package com.androidyug.mirror.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by IAMONE on 1/30/2016.
 */
public class FontsFactory {


    public static Typeface fontItalic(Context ctx){
        Typeface tf = Typeface.createFromAsset(ctx.getAssets(), "fonts/Whitney-BookItal-Bas.otf");
        return  tf;
    }


    public static Typeface fontStylish(Context ctx){
        Typeface tf = Typeface.createFromAsset(ctx.getAssets(), "fonts/Leitura-Display-Swashes.otf");
        return  tf;
    }




    public static Typeface fontBold(Context ctx){
        Typeface tf = Typeface.createFromAsset(ctx.getAssets(), "fonts/Whitney-Semibold-Bas.otf");
        return  tf;
    }



    public static Typeface fontRegular(Context ctx){
        Typeface tf = Typeface.createFromAsset(ctx.getAssets(), "fonts/Whitney-Book-Bas.otf");
        return  tf;
    }


}
