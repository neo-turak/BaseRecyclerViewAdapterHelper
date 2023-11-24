package com.chad.baserecyclerviewadapterhelper.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.adapter.UpFetchAdapter
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity
import com.chad.baserecyclerviewadapterhelper.entity.Movie
import com.chad.library.adapter.base.listener.OnUpFetchListener
import java.util.Random

/**
 * @author: limuyang
 * @date: 2019-12-06
 * @Description:
 */
class UpFetchUseActivity : BaseActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: UpFetchAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_universal_recycler)
        setBackBtn()
        setTitle("UpFetch Use")
        mRecyclerView = findViewById(R.id.rv)
        mRecyclerView.setLayoutManager(LinearLayoutManager(this))
        mAdapter = UpFetchAdapter()
        mRecyclerView.setAdapter(mAdapter)
        mAdapter.upFetchModule.setOnUpFetchListener(object : OnUpFetchListener {
            override fun onUpFetch() {
                requestUoFetch()
            }
        })
        mAdapter.upFetchModule.isUpFetchEnable = true
        mAdapter.setList(genData())
    }

    override fun onStart() {
        super.onStart()
        scrollToBottom()
    }

    private var count = 0
    private fun requestUoFetch() {
        count++

        // set fetching on when start network request.
        // 当开始网络请求数据的时候，设置状态为加载中
        mAdapter.upFetchModule.isUpFetching = true
        /*
         * get data from internet.
         */mRecyclerView.postDelayed({
            mAdapter.addData(0, genData())
            /*
                     * set fetching off when network request ends.
                     * 取消状态加载中的状态
                     */mAdapter.upFetchModule.isUpFetching = false
            if (count > 5) {
                /*
                         * set fetch enable false when you don't need anymore.
                         * 不需要功能后，将其关闭
                         */
                mAdapter.upFetchModule.isUpFetchEnable = false
            }
        }, 300)
    }

    /**
     * 滚动到底部（不带动画）
     */
    private fun scrollToBottom() {
        val ll = mRecyclerView.layoutManager as LinearLayoutManager?
        ll!!.scrollToPositionWithOffset(bottomDataPosition, 0)
    }

    /**
     * 滚动到底部（带动画）
     */
    private fun smoothScrollToBottom() {
        if (mAdapter.items.isEmpty()) {
            return
        }
        mRecyclerView.post { mRecyclerView.smoothScrollToPosition(bottomDataPosition) }
    }

    private val bottomDataPosition: Int
         get() = mAdapter.headerLayoutCount + mAdapter.items.size - 1

    private fun genData(): List<Movie> {
        val list = ArrayList<Movie>()
        val random = Random()
        for (i in 0..9) {
            val name = "Chad"
            val price = random.nextInt(10) + 10
            val len = random.nextInt(80) + 60
            val movie =
                Movie(name, len, price, "He was one of Australia's most distinguished artistes")
            list.add(movie)
        }
        return list
    }
}
