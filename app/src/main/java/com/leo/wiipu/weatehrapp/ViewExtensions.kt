package com.leo.wiipu.weatehrapp

import android.content.Context
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView

/**
 * Created by changliliao on 2017/4/10.
 */

val View.ctx:Context
    get() = context

var TextView.textColor:Int
 get() = currentTextColor
 set(value) = setTextColor(value)

fun Toolbar.slideExit(){
    if (translationY==0f) animate().translationY(-height.toFloat())
}

fun Toolbar.slideEnter(){
    if (translationY<0f)animate().translationY(0f)
}