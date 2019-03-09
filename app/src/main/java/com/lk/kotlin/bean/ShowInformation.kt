package com.lk.kotlin.bean

/**
 * date:2019/3/7
 * author:李阔(淡意衬优柔)
 * function:
 */
data class ShowInformation(
    val message: String,
    val result: List<Result>,
    val status: String
)

data class Result(
    val collection: Int,
    val id: Int,
    val infoAdvertisingVo: InfoAdvertisingVo,
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

data class InfoAdvertisingVo(
    val content: String,
    val id: Int,
    val pic: String,
    val url: String
)