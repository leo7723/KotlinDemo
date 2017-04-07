package com.leo.wiipu.weatehrapp

import android.app.Application
import android.database.sqlite.SQLiteOpenHelper
import kotlin.properties.Delegates

/**
 * Created by changliliao on 2017/4/7.
 */
class BaseApplication :Application(){

    //Kotlin不支持Static需要用companion来声明 但也有不同
    companion object{
        var instance :BaseApplication by Delegates.notNull<BaseApplication>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}