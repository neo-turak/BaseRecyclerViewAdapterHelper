/*
 * *
 *  * Copyright (c) 2023 Baray. All Rights Reserved.
 *  *
 *  * This software is the confidential and proprietary information of Baray
 *  * ("Confidential Information"). You shall not disclose such Confidential
 *  * Information and shall use it only in accordance with the terms of the
 *  * license agreement you entered into with Baray.
 *  *
 *  * This notice may not be removed or altered from any source distribution.
 *
 *
 */

package com.chad.library.adapter.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.tawarim.library.base.VBViewHolder
import java.lang.reflect.ParameterizedType


abstract class BaseBindingAdapter<VB : ViewBinding, T>(data: MutableList<T>? = null) :
    BaseQuickAdapter<T, VBViewHolder<VB>>(0, data) {

    //重写返回自定义 ViewHolder
    @Suppress("UNCHECKED_CAST")
    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): VBViewHolder<VB> {
        //这里为了使用简洁性，使用反射来实例ViewBinding
        val vbClass: Class<VB> =
            (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VB>
        val inflate = vbClass.getDeclaredMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )
        val mBinding =
            inflate.invoke(null, LayoutInflater.from(parent.context), parent, false) as VB
        return VBViewHolder(mBinding, mBinding.root)
    }
}