package com.chad.baserecyclerviewadapterhelper.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.adapter.diffUtil.DiffDemoCallback
import com.chad.baserecyclerviewadapterhelper.adapter.diffUtil.DiffUtilAdapter
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity
import com.chad.baserecyclerviewadapterhelper.model.DataServer
import com.chad.baserecyclerviewadapterhelper.entity.DiffUtilDemoEntity

/**
 * Created by limuyang
 * Date: 2019/7/14
 */
class DiffUtilActivity : BaseActivity() {
    private var mRecyclerView: RecyclerView? = null
    private var itemChangeBtn: Button? = null
    private var notifyChangeBtn: Button? = null
    private var mAdapter: DiffUtilAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diffutil)
        setBackBtn()
        setTitle("DiffUtil Use")
        findView()
        initRv()
        initClick()
    }

    private fun findView() {
        mRecyclerView = findViewById(R.id.diff_rv)
        itemChangeBtn = findViewById(R.id.item_change_btn)
        notifyChangeBtn = findViewById(R.id.notify_change_btn)
    }

    private fun initRv() {
        mAdapter = DiffUtilAdapter(DataServer.diffUtilDemoEntities)
        mRecyclerView!!.setAdapter(mAdapter)
        val view = layoutInflater.inflate(R.layout.head_view, mRecyclerView, false)
        view.findViewById<View>(R.id.iv).visibility =
            View.GONE
        mAdapter!!.addHeaderView(view)

        // 必须设置Diff Callback
        mAdapter!!.setDiffCallback(DiffDemoCallback())
    }

    private fun initClick() {
        itemChangeBtn!!.setOnClickListener {
            val newData: MutableList<DiffUtilDemoEntity> = newList
            mAdapter!!.setDiffNewData(newData)
        }
        notifyChangeBtn!!.setOnClickListener { // change item 0
            mAdapter!!.items[0] = DiffUtilDemoEntity(
                1,
                "😊😊Item " + 0,
                "Item " + 0 + " content have change (notifyItemChanged)",
                "06-12"
            )
            mAdapter!!.notifyItemChanged(
                0 + mAdapter!!.headerLayoutCount,
                DiffUtilAdapter.ITEM_0_PAYLOAD
            )
        }
    }

    private val newList: MutableList<DiffUtilDemoEntity>
        /**
         * get new data
         *
         * @return
         */
         get() {
            val list: MutableList<DiffUtilDemoEntity> = ArrayList()
            for (i in 0..9) {
                /*
            Simulate deletion of data No. 1 and No. 3
            模拟删除1号和3号数据
             */
                if (i == 1 || i == 3) {
                    continue
                }

                /*
            Simulate modification title of data No. 0
            模拟修改0号数据的title
             */if (i == 0) {
                    list.add(
                        DiffUtilDemoEntity(
                            i,
                            "😊Item $i",
                            "This item $i content",
                            "06-12"
                        )
                    )
                    continue
                }

                /*
            Simulate modification content of data No. 4
            模拟修改4号数据的content发生变化
             */if (i == 4) {
                    list.add(
                        DiffUtilDemoEntity(
                            i,
                            "Item $i",
                            "Oh~~~~~~, Item $i content have change",
                            "06-12"
                        )
                    )
                    continue
                }
                list.add(
                    DiffUtilDemoEntity(
                        i,
                        "Item $i",
                        "This item $i content",
                        "06-12"
                    )
                )
            }
            return list
        }
}
