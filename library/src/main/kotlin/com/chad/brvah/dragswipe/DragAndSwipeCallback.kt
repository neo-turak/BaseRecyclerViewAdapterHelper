package com.chad.library.adapter.base.dragswipe

import android.graphics.Canvas
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.R
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.BaseDraggableModule

/**
 * @author luoxw
 * @date 2016/6/20
 */
class DragAndSwipeCallback(private val mDraggableModule: BaseDraggableModule? = null) :
    ItemTouchHelper.Callback() {
    private var mMoveThreshold = 0.1f
    private var mSwipeThreshold = 0.7f
    private var mDragMoveFlags =
        ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
    private var mSwipeMoveFlags = ItemTouchHelper.END
    override fun isLongPressDragEnabled(): Boolean {
        return if (mDraggableModule != null) {
            mDraggableModule.isDragEnabled && !mDraggableModule.hasToggleView()
        } else false
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return mDraggableModule?.isSwipeEnabled ?: false
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        if (actionState == ItemTouchHelper.ACTION_STATE_DRAG
            && !isViewCreateByAdapter(viewHolder!!)
        ) {
            mDraggableModule?.onItemDragStart(viewHolder)
            viewHolder.itemView.setTag(R.id.BaseQuickAdapter_dragging_support, true)
        } else if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE
            && !isViewCreateByAdapter(viewHolder!!)
        ) {
            mDraggableModule?.onItemSwipeStart(viewHolder)
            viewHolder.itemView.setTag(R.id.BaseQuickAdapter_swiping_support, true)
        }
        super.onSelectedChanged(viewHolder, actionState)
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
        if (isViewCreateByAdapter(viewHolder)) {
            return
        }
        if (viewHolder.itemView.getTag(R.id.BaseQuickAdapter_dragging_support) != null
            && viewHolder.itemView.getTag(R.id.BaseQuickAdapter_dragging_support) as Boolean
        ) {
            mDraggableModule?.onItemDragEnd(viewHolder)
            viewHolder.itemView.setTag(R.id.BaseQuickAdapter_dragging_support, false)
        }
        if (viewHolder.itemView.getTag(R.id.BaseQuickAdapter_swiping_support) != null
            && viewHolder.itemView.getTag(R.id.BaseQuickAdapter_swiping_support) as Boolean
        ) {
            mDraggableModule?.onItemSwipeClear(viewHolder)
            viewHolder.itemView.setTag(R.id.BaseQuickAdapter_swiping_support, false)
        }
    }

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return if (isViewCreateByAdapter(viewHolder)) {
            makeMovementFlags(0, 0)
        } else makeMovementFlags(
            mDragMoveFlags,
            mSwipeMoveFlags
        )
    }

    override fun onMove(
        recyclerView: RecyclerView,
        source: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return source.itemViewType == target.itemViewType
    }

    override fun onMoved(
        recyclerView: RecyclerView,
        source: RecyclerView.ViewHolder,
        fromPos: Int,
        target: RecyclerView.ViewHolder,
        toPos: Int,
        x: Int,
        y: Int
    ) {
        super.onMoved(recyclerView, source, fromPos, target, toPos, x, y)
        mDraggableModule?.onItemDragMoving(source, target)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if (!isViewCreateByAdapter(viewHolder)) {
            mDraggableModule?.onItemSwiped(viewHolder)
        }
    }

    override fun getMoveThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return mMoveThreshold
    }

    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return mSwipeThreshold
    }

    /**
     * Set the fraction that the user should move the View to be considered as swiped.
     * The fraction is calculated with respect to RecyclerView's bounds.
     *
     *
     * Default value is .5f, which means, to swipe a View, user must move the View at least
     * half of RecyclerView's width or height, depending on the swipe direction.
     *
     * @param swipeThreshold A float value that denotes the fraction of the View size. Default value
     * is .8f .
     */
    fun setSwipeThreshold(swipeThreshold: Float) {
        mSwipeThreshold = swipeThreshold
    }

    /**
     * Set the fraction that the user should move the View to be considered as it is
     * dragged. After a view is moved this amount, ItemTouchHelper starts checking for Views
     * below it for a possible drop.
     *
     * @param moveThreshold A float value that denotes the fraction of the View size. Default value is
     * .1f .
     */
    fun setMoveThreshold(moveThreshold: Float) {
        mMoveThreshold = moveThreshold
    }

    /**
     *
     * Set the drag movement direction.
     *
     * The value should be ItemTouchHelper.UP, ItemTouchHelper.DOWN, ItemTouchHelper.LEFT, ItemTouchHelper.RIGHT or their combination.
     * You can combine them like ItemTouchHelper.UP | ItemTouchHelper.DOWN, it means that the item could only move up and down when dragged.
     *
     * @param dragMoveFlags the drag movement direction. Default value is ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT.
     */
    fun setDragMoveFlags(dragMoveFlags: Int) {
        mDragMoveFlags = dragMoveFlags
    }

    /**
     *
     * Set the swipe movement direction.
     *
     * The value should be ItemTouchHelper.START, ItemTouchHelper.END or their combination.
     * You can combine them like ItemTouchHelper.START | ItemTouchHelper.END, it means that the item could swipe to both left or right.
     *
     * @param swipeMoveFlags the swipe movement direction. Default value is ItemTouchHelper.END.
     */
    fun setSwipeMoveFlags(swipeMoveFlags: Int) {
        mSwipeMoveFlags = swipeMoveFlags
    }

    override fun onChildDrawOver(
        c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
        dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean
    ) {
        super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE
            && !isViewCreateByAdapter(viewHolder)
        ) {
            val itemView = viewHolder.itemView
            c.save()
            if (dX > 0) {
                c.clipRect(
                    itemView.left.toFloat(), itemView.top.toFloat(),
                    itemView.left + dX, itemView.bottom.toFloat()
                )
                c.translate(itemView.left.toFloat(), itemView.top.toFloat())
            } else {
                c.clipRect(
                    itemView.right + dX, itemView.top.toFloat(),
                    itemView.right.toFloat(), itemView.bottom.toFloat()
                )
                c.translate(itemView.right + dX, itemView.top.toFloat())
            }
            mDraggableModule?.onItemSwiping(c, viewHolder, dX, dY, isCurrentlyActive)
            c.restore()
        }
    }

    private fun isViewCreateByAdapter(viewHolder: RecyclerView.ViewHolder): Boolean {
        val type = viewHolder.itemViewType
        return type == BaseQuickAdapter.HEADER_VIEW || type == BaseQuickAdapter.LOAD_MORE_VIEW || type == BaseQuickAdapter.FOOTER_VIEW || type == BaseQuickAdapter.EMPTY_VIEW
    }
}
