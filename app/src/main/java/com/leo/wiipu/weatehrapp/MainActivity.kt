package com.leo.wiipu.weatehrapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*//导入layout ID
import org.jetbrains.anko.*


class MainActivity : AppCompatActivity() {

    val url="http://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=b1b15e88fa797225412429c1c50c122a1"

    //Kotlin 的Collections 类
    private val list= listOf("Beijing-Sunny-1.1","Beijing-Sunny-1.1",
            "Beijing-Sunny-1.1","Beijing-Sunny-1.1","Beijing-Sunny-1.1")
    //改成大括号不行 出错会表示成多行语句意思

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*text.text="Hello Kotlin";//可以不要分号*/

        val forecastList = findViewById(R.id.forecast_list) as RecyclerView;
        forecastList.layoutManager=LinearLayoutManager(this);
        forecastList.adapter=ForecastListAdapter(list)

        this.toast("Hello Util",Toast.LENGTH_SHORT)

        toast("Hello Anko")

        longToast(R.id.text)

        btn3.setOnClickListener ({startActivity<Main2Activity>()})

    }

    fun add(x:Int):Int{
        return 3;
    }

    fun toast(msg:String,length:Int=Toast.LENGTH_SHORT){
        Toast.makeText(this,msg,length).show();
    }

    fun internet(){
        async {
            val reslut=Request(url).run()
            onUiThread { longToast(reslut) }
        }
    }

    fun componentX(){
        val map= mapOf<Int,String>()
        for ((key,value) in map){
            Log.d("map","key$key,value$value")
        }
    }
}
