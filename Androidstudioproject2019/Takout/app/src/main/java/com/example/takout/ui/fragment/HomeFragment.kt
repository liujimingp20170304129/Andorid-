package com.example.takout.ui.fragment


import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.takout.R
import com.example.takout.ui.adapter.HomeRvAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.find


class HomeFragment : androidx.fragment.app.Fragment() {

    lateinit var homeRvAdapter: HomeRvAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, R.layout.fragment_home,null)
        val rvHome = view.find<RecyclerView>(R.id.rv_home)
        rvHome.layoutManager = LinearLayoutManager(activity)     //从上倒下列表视图
        homeRvAdapter = HomeRvAdapter(activity)
        rvHome.adapter = homeRvAdapter

        distance = 120.dp2px()
        return view
    }

    fun Int.dp2px(): Int{
        return  TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            toFloat(),resources.displayMetrics).toInt()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
    }




    val datas : ArrayList<String> = ArrayList<String>()
    var sum:Int = 0
     var distance:Int =0
    var alpha = 55

    private fun initData() {
        for (i in 0 until 100) {
            datas.add("我是商家：" + i)
        }
        homeRvAdapter.setData(datas)

        //滚动页面顶部颜色渐变
        rv_home.setOnScrollListener(object  : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                sum += dy

                if(sum > distance){
                    alpha = 255
                }else {
//                    alpha += (sum * 100 / distance).toInt()
                    alpha += sum *  1/ distance
                    alpha += 5
                }
                Log.e("home","alpha$alpha")
                ll_title_container.setBackgroundColor(Color.argb(alpha,0x31,0x90,0xe8))
            }
        })
    }
}
