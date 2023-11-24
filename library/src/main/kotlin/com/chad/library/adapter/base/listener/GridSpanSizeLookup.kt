package com.chad.library.adapter.base.listener

import androidx.recyclerview.widget.GridLayoutManager

/**
 * @author: limuyang
 * @date: 2019-12-03
 * @Description:
 */
interface GridSpanSizeLookup {
    fun getSpanSize(gridLayoutManager: GridLayoutManager, viewType: Int, position: Int): Int
}
