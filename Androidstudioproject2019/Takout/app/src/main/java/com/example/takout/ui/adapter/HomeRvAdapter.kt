package com.example.takout.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.annotation.IntegerRes
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.example.takout.R
import org.jetbrains.anko.find

class HomeRvAdapter(val context: FragmentActivity?) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        val TYPE_TITLE = 0
        val TYPE_SELLER = 1
    }

    /**
     * 不同的position对应不同类型
     */





    var mDatas :ArrayList<String> = ArrayList()

    override fun getItemViewType(position: Int): Int {
        if (position == 0){
            return TYPE_TITLE
        }else{
            return TYPE_SELLER
        }

    }

    fun setData(data: ArrayList<String>){
        this.mDatas = data
        notifyDataSetChanged()
    }

    //绑定数据用的
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        when(viewType){
            TYPE_TITLE -> (holder as TitleHolder).bindData("我是大哥-------------------------------------------")
            TYPE_SELLER -> (holder as SelleerHolder).bindData(mDatas[position - 1])
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
    //创建holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            TYPE_TITLE -> return TitleHolder(View.inflate(context,R.layout.item_title,null))
            TYPE_SELLER -> return SelleerHolder(View.inflate(context, R.layout.item_seller,null))
            else -> return TitleHolder(View.inflate(context,R.layout.item_home_common,null))
        }

    }





//轮播图
//    val urlMaps : HashMap<String ,String> = HashMap()
    inner class  TitleHolder(item :View) : RecyclerView.ViewHolder(item){
//        val  sliderLayout : SliderLayout
        init {
//            sliderLayout = item.findViewById(R.id.slider_layout)
        }

        fun  bindData(data: String){
//            if (urlMaps.size == 0){
//                urlMaps.put("Hannibal" , "https://p3.ssl.qhimgs1.com/sdr/400__/t01629a50d3dadb8d09.jpg")
//                urlMaps.put("Hannibal" , "https://p3.ssl.qhimgs1.com/sdr/400__/t01629a50d3dadb8d09.jpg")
//                urlMaps.put("Hannibal" , "https://p3.ssl.qhimgs1.com/sdr/400__/t01629a50d3dadb8d09.jpg")
//                urlMaps.put("Hannibal" , "https://p3.ssl.qhimgs1.com/sdr/400__/t01629a50d3dadb8d09.jpg")
//            }
//            for ((key , value) in urlMaps){
//               var textSliderView : TextSliderView = TextSliderView(context)
//                textSliderView.description(key).image(value)
//                sliderLayout.addSlider(textSliderView)
//            }
        }
    }


    inner class  SelleerHolder(item :View) : RecyclerView.ViewHolder(item){
            init {

        }
        fun  bindData(data: String){

        }
    }

}
