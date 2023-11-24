package com.chad.baserecyclerviewadapterhelper.activity.multi

import android.content.Intent
import android.os.Bundle
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity
import com.chad.baserecyclerviewadapterhelper.databinding.ActivityChooseMultipleItemUseTypeBinding

/**
 * https://github.com/chaychan
 *
 * @author ChayChan
 * @description: ChooseMultipleItemUseType
 * @date 2018/3/30  10:14
 */
class ChooseMultipleItemUseTypeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChooseMultipleItemUseTypeBinding.inflate(
            layoutInflater
        )
        setContentView(binding.getRoot())
        setTitle("MultipleItem Use")
        setBackBtn()
        binding.cardView0.setOnClickListener {
            startActivity(
                Intent(
                    this@ChooseMultipleItemUseTypeActivity,
                    BinderUseActivity::class.java
                )
            )
        }
        binding.cardView1.setOnClickListener {
            startActivity(
                Intent(
                    this@ChooseMultipleItemUseTypeActivity,
                    MultiItemQuickUseActivity::class.java
                )
            )
        }
        binding.cardView2.setOnClickListener {
            startActivity(
                Intent(
                    this@ChooseMultipleItemUseTypeActivity,
                    MultiItemDelegateUseActivity::class.java
                )
            )
        }
        binding.cardView3.setOnClickListener {
            startActivity(
                Intent(
                    this@ChooseMultipleItemUseTypeActivity,
                    MultiItemProviderUseActivity::class.java
                )
            )
        }
    }
}
