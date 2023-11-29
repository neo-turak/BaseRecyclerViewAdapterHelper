package com.chad.library.adapter.base.listener

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by luoxw on 2016/6/20.
 */
interface OnItemDragListener {
    fun onItemDragStart(viewHolder: RecyclerView.ViewHolder?, pos: Int)
    fun onItemDragMoving(
        source: RecyclerView.ViewHolder?,
        from: Int,
        target: RecyclerView.ViewHolder?,
        to: Int
    )

    fun onItemDragEnd(viewHolder: RecyclerView.ViewHolder?, pos: Int)
}
