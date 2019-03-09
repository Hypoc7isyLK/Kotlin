package com.example.rxlambda

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import android.widget.ListView
import com.example.rxlambda.adapter.InformationAdapter
import com.example.rxlambda.adapter.MAdapter
import com.example.rxlambda.bean.InformationBean
import com.example.rxlambda.bean.Result
import com.rxlambda.BaseApplication
import com.wtz.tj.zjz.mis.util.runRxLambda
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    var mInformationAdapter: InformationAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            loadOrg()

    }

    private fun loadOrg() {
        runRxLambda(BaseApplication.App().getService().InformationList("0","1","20"), {
            /*toast("success")
            deBug(it.toString())
            Toast.makeText(this,it.result.data.get(0).title,Toast.LENGTH_SHORT).show();*/
            sha(it)

        }, {
            it?.printStackTrace()
            toast("fail")
        })
    }

    private fun sha(it: Result<List<InformationBean>>) {
        val mRecyclerView = findViewById(R.id.recyclerview) as RecyclerView
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        /*var list = ArrayList<InformationBean>()
        var mListData = it.result*/

        /*list.addAll(mListData)*/
        mInformationAdapter = InformationAdapter(this)
/*        mInformationAdapter!!.clear()*/
        Log.e("lk",it.result.size.toString())
        mInformationAdapter!!.reset(it.result)
        mRecyclerView.adapter = mInformationAdapter


        mInformationAdapter!!.setSharefenxiang(object : InformationAdapter.Sharefenxiang {
            override fun sharessuccess(title: String) {
                toast(title)
            }
        })

    }



    /*class MAdapter(val stringList: ArrayList<Step>, val mContext: Context) : BaseAdapter() {
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
            holder.s.text = stringList[position].step
            return v
        }

        override fun getItem(position: Int): String {

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
    }*/
}
