package com.rxlambda

import com.example.rxlambda.bean.InformationBean
import com.example.rxlambda.bean.Result
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Created by Administrator on 2018/1/20.
 * 自定义请求接口的方法
 */
interface RetrofitService {

    @GET("information/v1/infoRecommendList")
    fun InformationList(
        /*@Header("userId") userId:String,
        @Header("sessionId") sessionId:String,
        @Query("page") page:String,
    @Query("count") count:String*/
            @Query("plateId") plateId:String,
            @Query("page") page:String,
            @Query("count") count:String

    ):Observable<Result<List<InformationBean>>>
}