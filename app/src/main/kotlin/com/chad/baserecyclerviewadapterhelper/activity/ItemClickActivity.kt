package com.chad.baserecyclerviewadapterhelper.activity

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.adapter.ItemClickAdapter
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity
import com.chad.baserecyclerviewadapterhelper.entity.ClickEntity
import com.chad.baserecyclerviewadapterhelper.utils.Tips
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.chad.library.adapter.base.listener.OnItemChildLongClickListener
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.listener.OnItemLongClickListener

/**
 * @author Allen
 */
class ItemClickActivity : BaseActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private var adapter: ItemClickAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_universal_recycler)
        setBackBtn()
        setTitle("ItemClickActivity Activity")
        mRecyclerView = findViewById(R.id.rv)
        mRecyclerView.setLayoutManager(LinearLayoutManager(this))
        initAdapter()
        adapter!!.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
                Tips.show("onItemClick $position")
            }
        })
        adapter!!.setOnItemLongClickListener(object : OnItemLongClickListener {
            override fun onItemLongClick(
                adapter: BaseQuickAdapter<*, *>,
                view: View,
                position: Int
            ): Boolean {
                Tips.show("onItemLongClick $position")
                return true
            }
        })
        adapter!!.setOnItemChildClickListener(object : OnItemChildClickListener {
            override fun onItemChildClick(
                adapter: BaseQuickAdapter<*, *>,
                view: View,
                position: Int
            ) {
                Tips.show("onItemChildClick $position")
            }
        })
        adapter!!.setOnItemChildLongClickListener(object : OnItemChildLongClickListener {
            override fun onItemChildLongClick(
                adapter: BaseQuickAdapter<*, *>,
                view: View,
                position: Int
            ): Boolean {
                Tips.show("onItemChildLongClick $position")
                return true
            }
        })
    }

    private fun initAdapter() {
        val data: MutableList<ClickEntity> = ArrayList()
        data.add(ClickEntity(ClickEntity.CLICK_ITEM_VIEW))
        data.add(ClickEntity(ClickEntity.CLICK_ITEM_CHILD_VIEW))
        data.add(ClickEntity(ClickEntity.LONG_CLICK_ITEM_VIEW))
        data.add(ClickEntity(ClickEntity.LONG_CLICK_ITEM_CHILD_VIEW))
        data.add(ClickEntity(ClickEntity.NEST_CLICK_ITEM_CHILD_VIEW))
        adapter = ItemClickAdapter(data)
        adapter!!.animationEnable = true
        mRecyclerView!!.setAdapter(adapter)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        return super.dispatchTouchEvent(ev)
    }
}
