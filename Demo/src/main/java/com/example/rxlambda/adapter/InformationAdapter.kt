package com.example.rxlambda.adapter

import android.content.Context

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.rxlambda.R
import com.example.rxlambda.bean.InformationBean


import java.util.ArrayList

/**
 * date:2019/2/19
 * author:李阔(淡意衬优柔)
 * function:
 */
class InformationAdapter(context: Context) : RecyclerView.Adapter<InformationAdapter.ViewHolder>() {
    var mContext: Context
    //    var mData: ArrayList<MovieBean> = ArrayList()
    var mData: List<InformationBean> = ArrayList()
    init {
        mContext = context
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.informationlist1_item, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        Log.e("lk","${mData.get(0).title}")
        p0.titleTv.setText(mData.get(p1).title)
        Glide.with(mContext).load(mData.get(p1).thumbnail).into(p0!!.thumbImg)
//        Glide.with(mContext).load(mData.get(p1).thumbnail).into(p0!!.thumbImg)
        p0.itemView.setOnClickListener {
            mSharefenxiang!!.sharessuccess(mData.get(p1).title+"")
        }

    }


    fun reset(data: List<InformationBean>) {
        mData = data
        Log.e("lks","${mData.get(0).title}")
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = mData.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var thumbImg: ImageView
        var titleTv: TextView

        init {
            titleTv = itemView.findViewById(R.id.title) as TextView
            thumbImg = itemView.findViewById(R.id.simpleview) as ImageView

        }
    }

    interface Sharefenxiang {

        fun sharessuccess(title: String)
    }

    private var mSharefenxiang: Sharefenxiang? = null

    fun setSharefenxiang(sharefenxiang: Sharefenxiang) {
        mSharefenxiang = sharefenxiang
    }

}
