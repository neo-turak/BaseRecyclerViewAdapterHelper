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

package com.tawarim.library.base

import android.view.View
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * @author 努尔江
 * Created on: 2023/4/27
 * @project hugo
 * Description:
 **/

class VBViewHolder<VB : ViewBinding>(val vb: VB, view: View) : BaseViewHolder(view)
