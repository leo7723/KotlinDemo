package com.leo.wiipu.weatehrapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*//导入layout ID
import org.jetbrains.anko.*


class MainActivity : AppCompatActivity(),ToolbarManager {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    val APPID="/dtype=json&ex_category=&key=28ecb150cc100527a00904508b114f44"
    val url="http://v.juhe.cn/expressonline/getCarriers.php$APPID"

    //Kotlin 的Collections 类
    private val list= listOf("Beijing-Sunny-1.1","Beijing-Sunny-1.1",
            "Beijing-Sunny-1.1","Beijing-Sunny-1.1","Beijing-Sunny-1.1")
    //改成大括号不行 出错会表示成多行语句意思
    private var  mainlist= ArrayList<Respose.Result>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        loadForecast()

        /*text.text="Hello Kotlin";//可以不要分号*/

        val forecastList = findViewById(R.id.forecast_list) as RecyclerView;
        forecastList.layoutManager=LinearLayoutManager(this);
        forecastList.adapter=ForecastListAdapter(mainlist){toast(it)}
        attachToScroll(forecastList)

        //SAN三个Toast例子
        //this.toast("Hello Util",Toast.LENGTH_SHORT)
        //toast("Hello Anko")
        //longToast(R.id.text)


        btn3.setOnClickListener ({ V -> startActivity<Main2Activity>()})

    }

    fun add(x:Int):Int{
        return 3;
    }

    fun ss()=3

    fun toast(msg:String,length:Int=Toast.LENGTH_SHORT){
        Toast.makeText(this,msg,length).show();
    }

    fun loadForecast(){
        async {
            val response=Respose(url)
            val reslut=response.execute()
            Log.d("KotlinNet",reslut.toString())
            mainlist.clear()
            mainlist.addAll(reslut.result)
        }
    }

    fun componentX(){
        val map= mapOf<Int,String>()
        for ((key,value) in map){
            Log.d("map","key$key,value$value")
        }
    }
}
