package com.chad.baserecyclerviewadapterhelper.entity

import com.chad.library.adapter.base.entity.JSectionEntity

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 *
 *
 * java请自定义类，继承于JSectionEntity抽象类。封装一遍自己的数据类
 *
 *
 * kotlin，数据类请直接实现SectionEntity接口即可，无需封装。
 */
class MySection(override val isHeader: Boolean,
                val obj: Any) : JSectionEntity()
