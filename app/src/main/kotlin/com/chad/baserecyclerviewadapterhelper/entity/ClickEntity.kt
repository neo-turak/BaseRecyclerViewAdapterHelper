/*
******************************* Copyright (c)*********************************\
**
**                 (c) Copyright 2015, Allen, china, shanghai
**                          All Rights Reserved
**
**                          
**                         
**-----------------------------------版本信息------------------------------------
** 版    本: V0.1
**
**------------------------------------------------------------------------------
********************************End of Head************************************\
*/
package com.chad.baserecyclerviewadapterhelper.entity

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * 文 件 名: ClickEntity
 * 创 建 人: Allen
 * 创建日期: 16/11/1 22:16
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
class ClickEntity(override var itemType: Int) : MultiItemEntity {

    companion object {
        const val CLICK_ITEM_VIEW = 1
        const val CLICK_ITEM_CHILD_VIEW = 2
        const val LONG_CLICK_ITEM_VIEW = 3
        const val LONG_CLICK_ITEM_CHILD_VIEW = 4
        const val NEST_CLICK_ITEM_CHILD_VIEW = 5
    }
}
