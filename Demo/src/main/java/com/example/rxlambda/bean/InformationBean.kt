package com.example.rxlambda.bean

/**
 * date:2019/3/8
 * author:李阔(淡意衬优柔)
 * function:
 */
data class InformationBean(
    val collection: Int,
    val id: Int,
    val releaseTime: Long,
    val share: Int,
    val source: String,
    val summary: String,
    val thumbnail: String,
    val title: String,
    val whetherAdvertising: Int,
    val whetherCollection: Int,
    val whetherPay: Int
)