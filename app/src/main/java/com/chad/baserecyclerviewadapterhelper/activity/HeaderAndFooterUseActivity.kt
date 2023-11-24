package com.chad.baserecyclerviewadapterhelper.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.adapter.HeaderAndFooterAdapter
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity
import com.chad.baserecyclerviewadapterhelper.utils.Tips
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
class HeaderAndFooterUseActivity : BaseActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private var adapter: HeaderAndFooterAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_universal_recycler)
        setBackBtn()
        setTitle("HeaderAndFooter Use")
        mRecyclerView = findViewById(R.id.rv)
        mRecyclerView.setLayoutManager(LinearLayoutManager(this))
        initAdapter()
        val headerView = getHeaderView(0
        ) { adapter!!.addHeaderView(getHeaderView(1, removeHeaderListener), 0) }
        adapter!!.addHeaderView(headerView)
        val footerView = getFooterView(0
        ) { adapter!!.addFooterView(getFooterView(1, removeFooterListener), 0) }
        adapter!!.addFooterView(footerView, 0)
        mRecyclerView.setAdapter(adapter)
    }

    private fun getHeaderView(type: Int, listener: View.OnClickListener): View {
        val view = layoutInflater.inflate(R.layout.head_view, mRecyclerView, false)
        if (type == 1) {
            val imageView = view.findViewById<ImageView>(R.id.iv)
            imageView.setImageResource(R.mipmap.rm_icon)
        }
        view.setOnClickListener(listener)
        return view
    }

    private fun getFooterView(type: Int, listener: View.OnClickListener): View {
        val view = layoutInflater.inflate(R.layout.footer_view, mRecyclerView, false)
        if (type == 1) {
            val imageView = view.findViewById<ImageView>(R.id.iv)
            imageView.setImageResource(R.mipmap.rm_icon)
        }
        view.setOnClickListener(listener)
        return view
    }

    private val removeHeaderListener: View.OnClickListener
         get() = View.OnClickListener { v -> adapter!!.removeHeaderView(v) }
    private val removeFooterListener: View.OnClickListener
         get() = View.OnClickListener { v -> adapter!!.removeFooterView(v) }

    private fun initAdapter() {
        adapter = HeaderAndFooterAdapter(PAGE_SIZE)
        adapter!!.animationEnable = true
        adapter!!.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
                Tips.show(position.toString())
            }
        })
    }

    companion object {
        private const val PAGE_SIZE = 3
    }
}
