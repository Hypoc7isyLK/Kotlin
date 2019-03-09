package com.example.rxlambda.bean

/**
 * date:2019/3/8
 * author:李阔(淡意衬优柔)
 * function:
 */
data class Result<T>(
    val message: String,
    val result: T,
    val status: String

)