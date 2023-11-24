package com.chad.baserecyclerviewadapterhelper.activity.multi

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.adapter.multi.ProviderMultiAdapter
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity
import com.chad.baserecyclerviewadapterhelper.entity.ProviderMultiEntity
import com.chad.baserecyclerviewadapterhelper.model.DataServer.providerMultiItemData

/**
 * @author: limuyang
 * @date: 2019-12-04
 * @Description:
 */
class MultiItemProviderUseActivity : BaseActivity() {
    private val adapter = ProviderMultiAdapter()
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
        val data: List<ProviderMultiEntity> = providerMultiItemData
        adapter.setList(data)
    }
}
