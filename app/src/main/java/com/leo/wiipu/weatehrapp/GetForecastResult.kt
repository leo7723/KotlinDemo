package com.leo.wiipu.weatehrapp

import com.google.gson.Gson
import java.net.URL

/**
 * 数据类示例
 * Created by changliliao on 2017/4/6.
 */
class GetForecastResult(val url:String){
    fun execute():ForecastResult{
        val forecastJsonStr = URL(url).readText();
        return Gson().fromJson(forecastJsonStr,ForecastResult::class.java)
    }

    data class ForecastResult(val coord: Coord,val sys: Sys,val weather: List<Weather>,
                              val base:String,val main: Main,val wind: Wind,val clouds: Clouds
                              ,val dt:Long,val id:Int,val name:String,val cod:Int)
    data class Coord(val lon:Int,val lat:Int)
    data class Sys(val type:Int,val id:Long,val message:Float,val country:String,val sunrise:Long,val sunset:Long)
    data class Main(val temp:Int,val hunmidity:Int,val pressur:Int,val temp_min: Int,val temp_max: Int)
    data class Wind(val speed:Float,val deg:Float)
    data class Clouds(val all:Int)
    data class Weather(val id:Int,val main:String,val description:String,val icon:String)

}


