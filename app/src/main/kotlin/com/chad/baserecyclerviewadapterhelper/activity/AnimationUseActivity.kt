package com.chad.baserecyclerviewadapterhelper.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.adapter.AnimationAdapter
import com.chad.baserecyclerviewadapterhelper.animator.CustomAnimation1
import com.chad.baserecyclerviewadapterhelper.animator.CustomAnimation2
import com.chad.baserecyclerviewadapterhelper.entity.Status
import com.chad.baserecyclerviewadapterhelper.utils.Tips
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.jaredrummler.materialspinner.MaterialSpinner
import com.kyleduo.switchbutton.SwitchButton

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 *
 *
 * modify by AllenCoder
 */
class AnimationUseActivity : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAnimationAdapter: AnimationAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter_use)
        mRecyclerView = findViewById(R.id.rv_list)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.setLayoutManager(LinearLayoutManager(this))
        initAdapter()
        initMenu()
        initView()
    }

    private fun initView() {
        val mImgBtn = findViewById<ImageView>(R.id.img_back)
        mImgBtn.setOnClickListener { finish() }
    }

    private fun initAdapter() {
        mAnimationAdapter = AnimationAdapter()
        mAnimationAdapter.animationEnable = true
        val mFirstPageItemCount = 3
        //        mAnimationAdapter.setNotDoAnimationCount(mFirstPageItemCount);
        mAnimationAdapter.addChildClickViewIds(R.id.img, R.id.tweetName, R.id.tweetText)
        mAnimationAdapter.setOnItemChildClickListener(object : OnItemChildClickListener {
            override fun onItemChildClick(
                adapter: BaseQuickAdapter<*, *>,
                view: View,
                position: Int
            ) {
                var content: String? = null
                val status = adapter.getItem(position) as Status
                when (view.id) {
                    R.id.img -> content = "img:" + status.userAvatar
                    R.id.tweetName -> content = "name:" + status.userName
                    R.id.tweetText -> content = "tweetText:" + status.userName
                    else -> {}
                }
                if (content != null) {
                    Tips.show(content)
                }
            }
        })
        mRecyclerView.setAdapter(mAnimationAdapter)
    }

    private fun initMenu() {
        val spinner = findViewById<MaterialSpinner>(R.id.spinner)
        spinner.setItems(
            "AlphaIn",
            "ScaleIn",
            "SlideInBottom",
            "SlideInLeft",
            "SlideInRight",
            "Custom1",
            "Custom2"
        )
        spinner.setOnItemSelectedListener { view, position, id, item ->
            when (position) {
                0 -> mAnimationAdapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.AlphaIn)
                1 -> mAnimationAdapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)
                2 -> mAnimationAdapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.SlideInBottom)
                3 -> mAnimationAdapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.SlideInLeft)
                4 -> mAnimationAdapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.SlideInRight)
                5 -> mAnimationAdapter.adapterAnimation = CustomAnimation1()
                6 -> mAnimationAdapter.adapterAnimation = CustomAnimation2()
                else -> {}
            }
            mRecyclerView.setAdapter(mAnimationAdapter)
        }
        //init firstOnly state
        mAnimationAdapter.isAnimationFirstOnly = false
        val switchButton = findViewById<SwitchButton>(R.id.switch_button)
        switchButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                mAnimationAdapter.isAnimationFirstOnly = true
            } else {
                mAnimationAdapter.isAnimationFirstOnly = false
            }
            mAnimationAdapter.notifyDataSetChanged()
        }
    }
}
