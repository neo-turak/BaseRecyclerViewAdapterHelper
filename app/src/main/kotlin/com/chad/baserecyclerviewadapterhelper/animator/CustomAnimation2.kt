package com.chad.baserecyclerviewadapterhelper.animator

import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.Interpolator
import com.chad.library.adapter.base.animation.BaseAnimation
import kotlin.math.pow
import kotlin.math.sin

/**
 * 自定义动画2
 */
class CustomAnimation2 : BaseAnimation {
    override fun animators(view: View): Array<Animator> {
        val translationX: Animator =
            ObjectAnimator.ofFloat(view, "translationX", -view.getRootView().width.toFloat(), 0f)
        translationX.setDuration(800)
        translationX.interpolator = MyInterpolator2()
        return arrayOf(translationX)
    }

    internal inner class MyInterpolator2 : Interpolator {
        override fun getInterpolation(input: Float): Float {
            val factor = 0.7f
            return (2.0.pow(-10.0 * input) * sin((input - factor / 4) * (2 * Math.PI) / factor) + 1).toFloat()
        }
    }
}