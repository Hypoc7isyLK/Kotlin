package com.lk.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}

fun main(args: Array<String>) {
    var name = arrayOf("王庆浩", "赵明珠", "李阔", "王思敏",
        "申雨轩", "冯向斌", "邵新轩", "蔺江涛",
        "贾蕊", "秦玉龙", "司腾", "王洁",
        "葛娟", "陈国星", "张懿旺", "王涵玉",
        "刘磊", "王子龙", "薛志民", "于振超",
        "李冠辉", "古祥坤", "张肖康", "夏洪武")
    var num: Int = 0

    num = Random().nextInt(24)

    var names =HashSet<String>()

    var i:Int = 0

    while(i<5 && names.size<5){

        var nextInt  = Random().nextInt(24)

        if(num != nextInt){
            names.add(name[nextInt].toString()+"  ")
        }

        i.inc()
    }

    println(name[num])

    for (n in names){

        print(n)
    }


}
