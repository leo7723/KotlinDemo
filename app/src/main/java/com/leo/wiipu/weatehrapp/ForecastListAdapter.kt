package com.leo.wiipu.weatehrapp

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * RecyclerView.Adapter 实例
 * Created by changliliao on 2017/4/6.
 */
class ForecastListAdapter (val list:List<String>):
        RecyclerView.Adapter<ForecastListAdapter.MyHolder>(){



    override fun onBindViewHolder(holder: MyHolder?, position: Int) {
        holder?.tv?.text=list[position]
        //list.[positon] 这里有坑
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
       return MyHolder(TextView(parent?.context))//？代表可以为空 ！！代表一定不为空否则抛出异常
    }

    override fun getItemCount(): Int =list.size

    class MyHolder(val tv:TextView):RecyclerView.ViewHolder(tv)
}