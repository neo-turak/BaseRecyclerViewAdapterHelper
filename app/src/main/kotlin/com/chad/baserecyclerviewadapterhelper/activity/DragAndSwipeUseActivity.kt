package com.chad.baserecyclerviewadapterhelper.activity

import android.animation.ValueAnimator
import android.graphics.Canvas
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.adapter.DragAndSwipeAdapter
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity
import com.chad.baserecyclerviewadapterhelper.utils.Tips
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.listener.OnItemDragListener
import com.chad.library.adapter.base.listener.OnItemSwipeListener
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class DragAndSwipeUseActivity : BaseActivity() {
    private  lateinit var mRecyclerView: RecyclerView
    private var mAdapter: DragAndSwipeAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_universal_recycler)
        setBackBtn()
        setTitle("Drag And Swipe")
        mRecyclerView = findViewById(R.id.rv)
        mRecyclerView.setLayoutManager(LinearLayoutManager(this))

        // 拖拽监听
        val listener: OnItemDragListener = object : OnItemDragListener {
            override fun onItemDragStart(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
                Log.d(TAG, "drag start")
                val holder = viewHolder as BaseViewHolder?

                // 开始时，item背景色变化，demo这里使用了一个动画渐变，使得自然
                val startColor = Color.WHITE
                val endColor = Color.rgb(245, 245, 245)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    val v = ValueAnimator.ofArgb(startColor, endColor)
                    v.addUpdateListener { animation ->
                        holder!!.itemView.setBackgroundColor(
                            animation.getAnimatedValue() as Int
                        )
                    }
                    v.setDuration(300)
                    v.start()
                }
            }

            override fun onItemDragMoving(
                source: RecyclerView.ViewHolder?,
                from: Int,
                target: RecyclerView.ViewHolder?,
                to: Int
            ) {
                Log.d(
                    TAG,
                    "move from: " + source!!.adapterPosition + " to: " + target!!.adapterPosition
                )
            }

            override fun onItemDragEnd(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
                Log.d(TAG, "drag end")
                val holder = viewHolder as BaseViewHolder?
                // 结束时，item背景色变化，demo这里使用了一个动画渐变，使得自然
                val startColor = Color.rgb(245, 245, 245)
                val endColor = Color.WHITE
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    val v = ValueAnimator.ofArgb(startColor, endColor)
                    v.addUpdateListener { animation ->
                        holder!!.itemView.setBackgroundColor(
                            animation.getAnimatedValue() as Int
                        )
                    }
                    v.setDuration(300)
                    v.start()
                }
            }
        }

        // 侧滑监听
        val onItemSwipeListener: OnItemSwipeListener = object : OnItemSwipeListener {
            override fun onItemSwipeStart(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
                Log.d(TAG, "view swiped start: $pos")
                val holder = viewHolder as BaseViewHolder?
            }

            override fun clearView(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
                Log.d(TAG, "View reset: $pos")
                val holder = viewHolder as BaseViewHolder?
            }

            override fun onItemSwiped(viewHolder: RecyclerView.ViewHolder?, pos: Int) {
                Log.d(TAG, "View Swiped: $pos")
            }

            override fun onItemSwipeMoving(
                canvas: Canvas?,
                viewHolder: RecyclerView.ViewHolder?,
                dX: Float,
                dY: Float,
                isCurrentlyActive: Boolean
            ) {
                canvas!!.drawColor(
                    ContextCompat.getColor(
                        this@DragAndSwipeUseActivity,
                        R.color.color_light_blue
                    )
                )
            }
        }
        val mData = generateData(50)
        mAdapter = DragAndSwipeAdapter(mData)
        mAdapter!!.draggableModule.isSwipeEnabled = true
        mAdapter!!.draggableModule.isDragEnabled = true
        mAdapter!!.draggableModule.setOnItemDragListener(listener)
        mAdapter!!.draggableModule.setOnItemSwipeListener(onItemSwipeListener)
        mAdapter!!.draggableModule.itemTouchHelperCallback.setSwipeMoveFlags(ItemTouchHelper.START or ItemTouchHelper.END)
        //mAdapter.getDraggableModule().getItemTouchHelperCallback().setDragMoveFlags(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.UP | ItemTouchHelper.DOWN);
        mRecyclerView.setAdapter(mAdapter)
        mAdapter!!.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
                Tips.show("点击了：$position")
            }
        })
    }

    private fun generateData(size: Int): MutableList<String> {
        val data = ArrayList<String>(size)
        for (i in 0 until size) {
            data.add("item $i")
        }
        return data
    }
}
