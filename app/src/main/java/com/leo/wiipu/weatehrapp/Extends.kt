package com.leo.wiipu.weatehrapp

import android.content.Context
import android.widget.Toast

/**
 * 扩展函数示例
 * Created by changliliao on 2017/4/6.
 */
class Extends(){
    fun Context.toast(msg:CharSequence,duration:Int=Toast.LENGTH_SHORT){
        Toast.makeText(this,msg,duration).show()
    }
}