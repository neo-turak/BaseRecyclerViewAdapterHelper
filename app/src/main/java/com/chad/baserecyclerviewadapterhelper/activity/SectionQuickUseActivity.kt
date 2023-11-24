package com.chad.baserecyclerviewadapterhelper.activity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.adapter.SectionQuickAdapter
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity
import com.chad.baserecyclerviewadapterhelper.model.DataServer
import com.chad.baserecyclerviewadapterhelper.decoration.GridSectionAverageGapItemDecoration
import com.chad.baserecyclerviewadapterhelper.entity.MySection
import com.chad.baserecyclerviewadapterhelper.entity.Video
import com.chad.baserecyclerviewadapterhelper.utils.Tips
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.chad.library.adapter.base.listener.OnItemClickListener

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
class SectionQuickUseActivity : BaseActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private var mData: MutableList<MySection> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_section_uer)
        setBackBtn()
        setTitle("Quick Section Use")
        mRecyclerView = findViewById(R.id.rv_list)
        mRecyclerView.setLayoutManager(GridLayoutManager(this, 3))
        mRecyclerView.addItemDecoration(GridSectionAverageGapItemDecoration(10f, 10f, 20f, 15f))
        mData = DataServer.getSectionData()
        val adapter =
            SectionQuickAdapter(R.layout.item_section_content, R.layout.def_section_head, mData)
        adapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
                val mySection = mData[position]
                if (mySection.isHeader) {
                    Tips.show(mySection.getObject() as String)
                } else {
                    val video = mySection.getObject() as Video
                    Tips.show(video.name)
                }
            }
        })
        adapter.setOnItemChildClickListener(object : OnItemChildClickListener {
            override fun onItemChildClick(
                adapter: BaseQuickAdapter<*, *>,
                view: View,
                position: Int
            ) {
                Tips.show("onItemChildClick: $position")
            }
        })
        mRecyclerView.setAdapter(adapter)
    }
}
