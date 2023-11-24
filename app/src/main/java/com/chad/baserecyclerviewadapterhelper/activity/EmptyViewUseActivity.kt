package com.chad.baserecyclerviewadapterhelper.activity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.adapter.EmptyViewAdapter
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity
import com.chad.baserecyclerviewadapterhelper.model.DataServer

class EmptyViewUseActivity : BaseActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private val mAdapter = EmptyViewAdapter()
    private var mError = true
    private var mNoData = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty_view_use)
        setBackBtn()
        setTitle("EmptyView Use")
        findViewById<View>(R.id.btn_reset).setOnClickListener { reset() }
        mRecyclerView = findViewById(R.id.rv_list)
        mRecyclerView.setLayoutManager(LinearLayoutManager(this))
        mRecyclerView.setAdapter(mAdapter)
    }

    override fun onStart() {
        super.onStart()
        onRefresh()
    }

    private fun reset() {
        mError = true
        mNoData = true
        mAdapter.setList(null)
        onRefresh()
    }

    private val emptyDataView: View
        private get() {
            val notDataView = layoutInflater.inflate(R.layout.empty_view, mRecyclerView, false)
            notDataView.setOnClickListener { onRefresh() }
            return notDataView
        }
    private val errorView: View
        private get() {
            val errorView = layoutInflater.inflate(R.layout.error_view, mRecyclerView, false)
            errorView.setOnClickListener { onRefresh() }
            return errorView
        }

    private fun onRefresh() {
        // 方式一：直接传入 layout id
        mAdapter.setEmptyView(R.layout.loading_view)
        mRecyclerView!!.postDelayed(object : Runnable {
            override fun run() {
                if (mError) {
                    // 方式二：传入View
                    mAdapter.setEmptyView(errorView)
                    mError = false
                } else {
                    if (mNoData) {
                        mAdapter.setEmptyView(emptyDataView)
                        mNoData = false
                    } else {
                        mAdapter.setList(DataServer.getSampleData(10))
                    }
                }
            }
        }, 1000)
    }
}
