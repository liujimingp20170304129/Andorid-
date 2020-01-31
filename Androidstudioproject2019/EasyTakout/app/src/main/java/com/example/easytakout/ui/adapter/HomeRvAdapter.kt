package com.example.takout.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.example.easytakout.R
import org.jetbrains.anko.find


class HomeRvAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        val TYPE_TITLE = 0
        val TYPE_SELLER = 1
    }

    /**
     * 不同的position对应不同类型
     */
    override fun getItemViewType(position: Int): Int {
        if (position ==0){
            return TYPE_TITLE
        }else{
            return TYPE_SELLER
        }
        return super.getItemViewType(position)
    }

    var mDatas :ArrayList<String> = ArrayList()
    fun setData(data: ArrayList<String>){
        this.mDatas = data
        notifyDataSetChanged()
    }

    //创建holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            TYPE_TITLE -> return TitleHolder(View.inflate(context,R.layout.item_home_common,null))
            TYPE_SELLER -> return SelleerHolder(View.inflate(context, R.layout.item_home_common,null))
            else -> return TitleHolder(View.inflate(context, R.layout.item_home_common,null))
        }

    }

    //列表输出有多少行数据
    override fun getItemCount(): Int {
       if(mDatas.size > 0) {
           return  mDatas.size + 1
       }else{
           return  0
       }

    }

    //绑定数据用的
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        when(viewType){
            TYPE_TITLE -> (holder as TitleHolder).bindData("我是大哥-------------------------------------------")
            TYPE_SELLER -> (holder as SelleerHolder).bindData(mDatas[position - 1])
        }

    }



    inner class  TitleHolder(item :View) : RecyclerView.ViewHolder(item){
        val textView : TextView
        init {
            textView = item.find(R.id.tv)
        }

        fun  bindData(data: String){
            textView.text = data
        }
    }


    inner class  SelleerHolder(item :View) : RecyclerView.ViewHolder(item){
        val textView : TextView
        init {
            textView = item.find(R.id.tv)
        }

        fun  bindData(data: String){
            textView.text = data
        }
    }

}
