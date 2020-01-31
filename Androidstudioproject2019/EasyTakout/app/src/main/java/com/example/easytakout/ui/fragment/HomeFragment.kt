package com.example.takout.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easytakout.R

import com.example.takout.ui.adapter.HomeRvAdapter
import org.jetbrains.anko.find


class HomeFragment : androidx.fragment.app.Fragment() {

    lateinit var homeRvAdapter: HomeRvAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, R.layout.fragment_home,null)
        val rvHome = view.find<RecyclerView>(R.id.rv_home)
        rvHome.layoutManager = LinearLayoutManager(activity)
        homeRvAdapter = HomeRvAdapter(activity)
        rvHome.adapter = homeRvAdapter

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
    }
    val datas : ArrayList<String> = ArrayList<String>()
    private fun initData() {
        for (i in 0 until 100) {
            datas.add("我是商家：" + i)
        }
        homeRvAdapter.setData(datas)
    }
}
