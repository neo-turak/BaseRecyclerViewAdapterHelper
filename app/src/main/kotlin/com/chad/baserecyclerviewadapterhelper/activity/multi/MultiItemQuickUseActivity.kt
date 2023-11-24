package com.chad.baserecyclerviewadapterhelper.activity.multi

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.adapter.multi.MultipleItemQuickAdapter
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity
import com.chad.baserecyclerviewadapterhelper.entity.QuickMultipleEntity
import com.chad.baserecyclerviewadapterhelper.model.DataServer.multipleItemData
import com.chad.library.adapter.base.listener.GridSpanSizeLookup

class MultiItemQuickUseActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_item_use)
        setTitle("BaseMultiItemQuickAdapter")
        setBackBtn()
        val mRecyclerView = findViewById<RecyclerView>(R.id.rv_list)
        val entities: MutableList<QuickMultipleEntity> = multipleItemData
        val multipleItemAdapter = MultipleItemQuickAdapter(entities)
        val manager = GridLayoutManager(this, 4)
        mRecyclerView.setLayoutManager(manager)
        multipleItemAdapter.setGridSpanSizeLookup(object : GridSpanSizeLookup {
            override fun getSpanSize(
                gridLayoutManager: GridLayoutManager,
                viewType: Int,
                position: Int
            ): Int {
                return entities[position].spanSize
            }
        })
        mRecyclerView.setAdapter(multipleItemAdapter)
    }
}
