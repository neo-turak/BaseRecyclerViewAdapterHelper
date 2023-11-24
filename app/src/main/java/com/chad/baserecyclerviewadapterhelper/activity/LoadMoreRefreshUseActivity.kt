package com.chad.baserecyclerviewadapterhelper.activity

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.adapter.LoadMoreAdapter
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity
import com.chad.baserecyclerviewadapterhelper.model.DataServer
import com.chad.baserecyclerviewadapterhelper.entity.Status
import com.chad.baserecyclerviewadapterhelper.loadmore.CustomLoadMoreView
import com.chad.baserecyclerviewadapterhelper.utils.Tips
import com.chad.library.adapter.base.listener.OnLoadMoreListener

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
class LoadMoreRefreshUseActivity : BaseActivity() {
    internal inner class PageInfo {
        var page = 0
        fun nextPage() {
            page++
        }

        fun reset() {
            page = 0
        }

        val isFirstPage: Boolean
            get() = page == 0
    }

    private var switchCompat: SwitchCompat? = null
    private var mRecyclerView: RecyclerView? = null
    private var mSwipeRefreshLayout: SwipeRefreshLayout? = null
    private var mAdapter: LoadMoreAdapter? = null
    private val pageInfo: PageInfo = PageInfo()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_more)
        setTitle("LoadMore Refresh Use")
        setBackBtn()
        switchCompat = findViewById(R.id.autoLoadMoreSwitch)
        mRecyclerView = findViewById(R.id.rv_list)
        mSwipeRefreshLayout = findViewById(R.id.swipeLayout)
        mRecyclerView!!.setLayoutManager(LinearLayoutManager(this))
        initAdapter()
        addHeadView()
        initRefreshLayout()
        initLoadMore()
        initSwitch()
    }

    override fun onStart() {
        super.onStart()
        // 进入页面，刷新数据
        mSwipeRefreshLayout!!.isRefreshing = true
        refresh()
    }

    private fun initAdapter() {
        mAdapter = LoadMoreAdapter()
        mAdapter!!.animationEnable = true
        mRecyclerView!!.setAdapter(mAdapter)
    }

    private fun addHeadView() {
        val headView =
            layoutInflater.inflate(R.layout.head_view, mRecyclerView!!.parent as ViewGroup, false)
        headView.findViewById<View>(R.id.iv).visibility = View.GONE
        (headView.findViewById<View>(R.id.tv) as TextView).text = "Change Custom LoadView"
        headView.setOnClickListener {
            mAdapter!!.setList(null)
            mAdapter!!.loadMoreModule.loadMoreView = CustomLoadMoreView()
            mRecyclerView!!.setAdapter(mAdapter)
            Tips.show("Change Complete")
            mSwipeRefreshLayout!!.isRefreshing = true
            refresh()
        }
        mAdapter!!.addHeaderView(headView)
    }

    private fun initRefreshLayout() {
        mSwipeRefreshLayout!!.setColorSchemeColors(Color.rgb(47, 223, 189))
        mSwipeRefreshLayout!!.setOnRefreshListener { refresh() }
    }

    /**
     * 初始化加载更多
     */
    private fun initLoadMore() {
        mAdapter!!.loadMoreModule.setOnLoadMoreListener(object : OnLoadMoreListener {
            override fun onLoadMore() {
                loadMore()
            }
        })
        mAdapter!!.loadMoreModule.isAutoLoadMore = true
        //当自动加载开启，同时数据不满一屏时，是否继续执行自动加载更多(默认为true)
        mAdapter!!.loadMoreModule.isEnableLoadMoreIfNotFullPage = false
    }

    private fun initSwitch() {
        switchCompat!!.setChecked(mAdapter!!.loadMoreModule.isAutoLoadMore)
        switchCompat!!.setOnCheckedChangeListener { buttonView, isChecked ->
            mAdapter!!.loadMoreModule.isAutoLoadMore = isChecked
            if (isChecked) {
                switchCompat!!.text = "自动加载（开）"
            } else {
                switchCompat!!.text = "自动加载（关）"
            }
        }
    }

    /**
     * 刷新
     */
    private fun refresh() {
        // 这里的作用是防止下拉刷新的时候还可以上拉加载
        mAdapter!!.loadMoreModule.isEnableLoadMore = false
        // 下拉刷新，需要重置页数
        pageInfo.reset()
        request()
    }

    /**
     * 加载更多
     */
    private fun loadMore() {
        request()
    }

    /**
     * 请求数据
     */
    private fun request() {
        Request(pageInfo.page, object : RequestCallBack {
            override fun success(data: List<Status?>) {
                mSwipeRefreshLayout!!.isRefreshing = false
                mAdapter!!.loadMoreModule.isEnableLoadMore = true
                if (pageInfo.isFirstPage) {
                    //如果是加载的第一页数据，用 setData()
                    mAdapter!!.setList(data)
                } else {
                    //不是第一页，则用add
                    mAdapter!!.addData(data)
                }
                if (data.size < PAGE_SIZE) {
                    //如果不够一页,显示没有更多数据布局
                    mAdapter!!.loadMoreModule.loadMoreEnd()
                    Tips.show("no more data")
                } else {
                    mAdapter!!.loadMoreModule.loadMoreComplete()
                }

                // page加一
                pageInfo.nextPage()
            }

            override fun fail(e: Exception?) {
                Tips.show(getResources().getString(R.string.network_err))
                mSwipeRefreshLayout!!.isRefreshing = false
                mAdapter!!.loadMoreModule.isEnableLoadMore = true
                mAdapter!!.loadMoreModule.loadMoreFail()
            }
        }).start()
    }

    /**
     * 模拟加载数据的类，不用特别关注
     */
    internal class Request(private val mPage: Int, private val mCallBack: RequestCallBack) :
        Thread() {
        private val mHandler: Handler

        init {
            mHandler = Handler(Looper.getMainLooper())
        }

        override fun run() {
            try {
                sleep(800)
            } catch (_: InterruptedException) {
            }
            if (mPage == 2 && mFirstError) {
                mFirstError = false
                mHandler.post { mCallBack.fail(RuntimeException("fail")) }
            } else {
                var size = PAGE_SIZE
                if (mPage == 1) {
                    if (mFirstPageNoMore) {
                        size = 1
                    }
                    mFirstPageNoMore = !mFirstPageNoMore
                    if (!mFirstError) {
                        mFirstError = true
                    }
                } else if (mPage == 4) {
                    size = 1
                }
                val dataSize = size
                mHandler.post { mCallBack.success(DataServer.getSampleData(dataSize)) }
            }
        }

        companion object {
            private var mFirstPageNoMore = false
            private var mFirstError = true
        }
    }

    internal interface RequestCallBack {
        /**
         * 模拟加载成功
         *
         * @param data 数据
         */
        fun success(data: List<Status?>)

        /**
         * 模拟加载失败
         *
         * @param e 错误信息
         */
        fun fail(e: Exception?)
    }

    companion object {
        private const val PAGE_SIZE = 5
    }
}