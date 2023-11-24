package com.chad.baserecyclerviewadapterhelper.adapter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.entity.ClickEntity
import com.chad.baserecyclerviewadapterhelper.utils.Tips
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 *
 */
class ItemClickAdapter(mItems: MutableList<ClickEntity>) :
    BaseMultiItemQuickAdapter<ClickEntity, BaseViewHolder>(mItems), OnItemClickListener,
    OnItemChildClickListener {
    init {
        addItemType(ClickEntity.CLICK_ITEM_VIEW, R.layout.item_click_view)
        addItemType(ClickEntity.CLICK_ITEM_CHILD_VIEW, R.layout.item_click_childview)
        addItemType(ClickEntity.LONG_CLICK_ITEM_VIEW, R.layout.item_long_click_view)
        addItemType(ClickEntity.LONG_CLICK_ITEM_CHILD_VIEW, R.layout.item_long_click_childview)
        addItemType(ClickEntity.NEST_CLICK_ITEM_CHILD_VIEW, R.layout.item_nest_click)
        addChildClickViewIds(
            R.id.btn,
            R.id.iv_num_reduce, R.id.iv_num_add,
            R.id.item_click
        )
        addChildLongClickViewIds(
            R.id.iv_num_reduce, R.id.iv_num_add,
            R.id.btn
        )
    }

     override fun convert(holder: BaseViewHolder, item: ClickEntity) {
        when (holder.itemViewType) {
            ClickEntity.CLICK_ITEM_VIEW -> {}
            ClickEntity.CLICK_ITEM_CHILD_VIEW -> {}
            ClickEntity.LONG_CLICK_ITEM_VIEW -> {}
            ClickEntity.LONG_CLICK_ITEM_CHILD_VIEW -> {}
            ClickEntity.NEST_CLICK_ITEM_CHILD_VIEW -> {
                // u can set nestview id
                val recyclerView = holder.getView<RecyclerView>(R.id.nest_list)
                recyclerView.setHasFixedSize(true)
                if (recyclerView.layoutManager == null) {
                    recyclerView.setLayoutManager(
                        LinearLayoutManager(
                            context,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                    )
                }
                if (recyclerView.adapter == null) {
                    val nestAdapter = NestAdapter()
                    nestAdapter.setOnItemClickListener(this)
                    nestAdapter.setOnItemChildClickListener(this)
                    recyclerView.setAdapter(nestAdapter)
                }
            }

            else -> {}
        }
    }

    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        Tips.show("childView click")
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        Tips.show("嵌套RecycleView item 收到: 点击了第 $position 一次")
    }
}
