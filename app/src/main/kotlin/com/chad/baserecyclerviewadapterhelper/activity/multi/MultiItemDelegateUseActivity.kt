package com.chad.baserecyclerviewadapterhelper.activity.multi

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.adapter.multi.DelegateMultiAdapter
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity
import com.chad.baserecyclerviewadapterhelper.entity.DelegateMultiEntity
import com.chad.baserecyclerviewadapterhelper.model.DataServer.delegateMultiItemData

class MultiItemDelegateUseActivity : BaseActivity() {
    private val adapter = DelegateMultiAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_item_use)
        setTitle("BaseMultiItemQuickAdapter")
        setBackBtn()
        initRv()
    }

    private fun initRv() {
        val mRecyclerView = findViewById<RecyclerView>(R.id.rv_list)
        mRecyclerView.setLayoutManager(LinearLayoutManager(this))
        mRecyclerView.setAdapter(adapter)
    }

    override fun onStart() {
        super.onStart()
        val data: List<DelegateMultiEntity> = delegateMultiItemData
        adapter.setList(data)
    }
}
