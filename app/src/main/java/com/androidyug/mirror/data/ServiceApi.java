package com.androidyug.mirror.data;

import android.content.Context;

import com.androidyug.mirror.data.model.Response;
import com.androidyug.mirror.utils.ZodiacFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Nicheminds on 6/27/2016.
 */
public class ServiceApi {

    private static ServiceApi instance = new ServiceApi();

    public static ServiceApi getInstance(){
        if (instance!=null){
            return instance;
        } else {
            return new ServiceApi();
        }
    }

    public  Response fetchZodiacData(Context ctx, int whichZodiac){
        switch (whichZodiac){
            case ZodiacFactory.AQUARIUS:
                return getJsonFromAsset("aquarius", ctx);
            case ZodiacFactory.ARIES:
                return getJsonFromAsset("aries", ctx);
            case ZodiacFactory.CANCER:
                return getJsonFromAsset("cancer", ctx);
            case ZodiacFactory.CAPRICORN:
                return getJsonFromAsset("capricorn", ctx);
            case ZodiacFactory.GEMINI:
                return getJsonFromAsset("gemini", ctx);
            case ZodiacFactory.LEO:
                return getJsonFromAsset("leo", ctx);
            case ZodiacFactory.LIBRA:
                return getJsonFromAsset("libra", ctx);
            case ZodiacFactory.PISCES:
                return getJsonFromAsset("pices", ctx);
            case ZodiacFactory.SAGITTARIUS:
                return getJsonFromAsset("sagittarius", ctx);
            case ZodiacFactory.SCORPIO:
                return getJsonFromAsset("scorpio", ctx);
            case ZodiacFactory.TAURUS:
                return getJsonFromAsset("taurus", ctx);
            case ZodiacFactory.VIRGO:
                return getJsonFromAsset("virgo", ctx);
            default:
                return null;
        }
    }


    private  Response getJsonFromAsset(String zodiac, Context ctx) {
        Response response;
        try {
            String path = "zodiac/" + zodiac+ ".json";
            InputStream is =ctx. getAssets().open(path);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String jsonString = new String(buffer);
            Gson gson = new GsonBuilder().create();
            response = gson.fromJson(jsonString, Response.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return response;
    }
}
