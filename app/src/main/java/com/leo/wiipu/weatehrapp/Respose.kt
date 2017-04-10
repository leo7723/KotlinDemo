package com.leo.wiipu.weatehrapp

import com.google.gson.Gson
import java.net.URL

/**
 * Created by changliliao on 2017/4/10.
 */
class Respose(val url: String){
    fun execute(): Main {
        val respoose = URL(url).readText();
        return Gson().fromJson(respoose,Main::class.java)
    }
    data class Main(val reason:String,val result:List<Result>,val error_code:Int)
    data class Result(val carrier_code :String,val carrier_phone:String,
                      val carrier_name: String)
}
