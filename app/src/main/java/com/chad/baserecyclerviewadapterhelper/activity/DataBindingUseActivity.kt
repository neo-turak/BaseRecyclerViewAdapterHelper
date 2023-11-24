package com.chad.baserecyclerviewadapterhelper.activity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.adapter.DataBindingAdapter
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity
import com.chad.baserecyclerviewadapterhelper.entity.Movie
import com.chad.baserecyclerviewadapterhelper.utils.Tips
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import java.util.Random

/**
 * @author: limuyang
 * @date: 2019-12-05
 * @Description:
 */
class DataBindingUseActivity : BaseActivity() {
    private val adapter = DataBindingAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_universal_recycler)
        setTitle("DataBinding Use")
        setBackBtn()
        val mRecyclerView = findViewById<RecyclerView>(R.id.rv)
        mRecyclerView.setLayoutManager(LinearLayoutManager(this))
        mRecyclerView.setAdapter(adapter)

        //demo 添加的 Header
        //Header 是自行添加进去的 View，所以 Adapter 不管理 Header 的 DataBinding。
        //请在外部自行完成数据的绑定
        val view = layoutInflater.inflate(R.layout.head_view, null, false)
        view.findViewById<View>(R.id.iv).visibility = View.GONE
        adapter.addHeaderView(view)

        //item 点击事件
        adapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
                Tips.show("onItemClick: $position")
            }
        })

        //设置数据
        adapter.setList(genData())
    }

    private fun genData(): List<Movie> {
        val list = ArrayList<Movie>()
        val random = Random()
        for (i in 0..9) {
            val name = "Chad $i"
            val price = random.nextInt(10) + 10
            val len = random.nextInt(80) + 60
            val movie =
                Movie(name, len, price, "He was one of Australia's most distinguished artistes")
            list.add(movie)
        }
        return list
    }
}
