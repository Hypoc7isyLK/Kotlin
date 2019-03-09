package com.example.rxlambda.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.rxlambda.R
import com.example.rxlambda.bean.InformationBean

/**
 * date:2019/3/8
 * author:李阔(淡意衬优柔)
 * function:
 */
class MAdapter(val stringList: ArrayList<InformationBean>, val mContext: Context): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: TexV
        var  v : View
        if (convertView == null) {
            v = View.inflate(mContext, R.layout.item, null);
            holder = TexV(v)
            v.tag = holder
        } else {
            v = convertView
            holder = convertView.tag as TexV
        }
        holder.s.text = stringList[position].toString()
        return v
    }

    override fun getItem(position: Int): Any {
        return stringList.get(position).toString()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return stringList.size
    }

    class TexV(var item: View) {
        var s: TextView = item.findViewById(R.id.item_text) as TextView;
    }

}