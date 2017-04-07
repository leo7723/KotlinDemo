package com.leo.wiipu.weatehrapp

import android.util.Log
import java.net.URL

/**
 * Created by changliliao on 2017/4/6.
 */

public class Request(val url:String){
    public fun run():String{
        val forecastJsonStr = URL(url).readText();
        Log.d(javaClass.simpleName,forecastJsonStr)
        return forecastJsonStr;
    }
}
