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

import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * @author 努尔江
 * Created on: 2023/5/12
 * @project hugo
 * Description:
 **/

class VBBaseViewHolder<VB : ViewBinding>(private val binding: VB) : BaseViewHolder(binding.root) {
}