package com.chad.baserecyclerviewadapterhelper.model

import com.chad.baserecyclerviewadapterhelper.entity.DelegateMultiEntity
import com.chad.baserecyclerviewadapterhelper.entity.DiffUtilDemoEntity
import com.chad.baserecyclerviewadapterhelper.entity.MySection
import com.chad.baserecyclerviewadapterhelper.entity.ProviderMultiEntity
import com.chad.baserecyclerviewadapterhelper.entity.QuickMultipleEntity
import com.chad.baserecyclerviewadapterhelper.entity.Status
import com.chad.baserecyclerviewadapterhelper.entity.Video

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
object DataServer {
    const val HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK =
        "https://avatars1.githubusercontent.com/u/7698209?v=3&s=460"
    const val CYM_CHAD = "CymChad"
    const val CHAY_CHAN = "ChayChan"
    fun getSampleData(lenth: Int): MutableList<Status> {
        val list: MutableList<Status> = ArrayList()
        for (i in 0 until lenth) {
            val status = Status()
            status.userName = "Chad$i"
            status.createdAt = "04/05/$i"
            status.isRetweet = i % 2 == 0
            status.userAvatar = "https://avatars1.githubusercontent.com/u/7698209?v=3&s=460"
            status.text = "BaseRecyclerViewAdpaterHelper https://www.recyclerview.org"
            list.add(status)
        }
        return list
    }

    fun addData(list: MutableList<Status>, dataSize: Int): MutableList<Status> {
        for (i in 0 until dataSize) {
            val status = Status()
            status.userName = "Chad$i"
            status.createdAt = "04/05/$i"
            status.isRetweet = i % 2 == 0
            status.userAvatar = "https://avatars1.githubusercontent.com/u/7698209?v=3&s=460"
            status.text =
                "Powerful and flexible RecyclerAdapter https://github.com/CymChad/BaseRecyclerViewAdapterHelper"
            list.add(status)
        }
        return list
    }

    val sectionData: MutableList<MySection>
        //    public static List<MySection> getSampleData() {
        get() {
            val list: MutableList<MySection> = ArrayList()
            for (i in 0..7) {
                list.add(MySection(true, "Section $i"))
                list.add(
                    MySection(
                        false,
                        Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)
                    )
                )
                list.add(
                    MySection(
                        false,
                        Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)
                    )
                )
                list.add(
                    MySection(
                        false,
                        Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)
                    )
                )
                list.add(
                    MySection(
                        false,
                        Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)
                    )
                )
                list.add(
                    MySection(
                        false,
                        Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)
                    )
                )
                list.add(
                    MySection(
                        false,
                        Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)
                    )
                )
            }
            return list
        }
    val strData: MutableList<String>
        get() {
            val list: MutableList<String> = ArrayList()
            for (i in 0..19) {
                var str = HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK
                if (i % 2 == 0) {
                    str = CYM_CHAD
                }
                list.add(str)
            }
            return list
        }
    @JvmStatic
    val multipleItemData: MutableList<QuickMultipleEntity>
        get() {
            val list: MutableList<QuickMultipleEntity> = ArrayList()
            for (i in 0..4) {
                list.add(
                    QuickMultipleEntity(
                        QuickMultipleEntity.IMG,
                        QuickMultipleEntity.IMG_SPAN_SIZE
                    )
                )
                list.add(
                    QuickMultipleEntity(
                        QuickMultipleEntity.TEXT,
                        QuickMultipleEntity.TEXT_SPAN_SIZE,
                        CYM_CHAD
                    )
                )
                list.add(
                    QuickMultipleEntity(
                        QuickMultipleEntity.IMG_TEXT,
                        QuickMultipleEntity.IMG_TEXT_SPAN_SIZE
                    )
                )
                list.add(
                    QuickMultipleEntity(
                        QuickMultipleEntity.IMG_TEXT,
                        QuickMultipleEntity.IMG_TEXT_SPAN_SIZE_MIN
                    )
                )
                list.add(
                    QuickMultipleEntity(
                        QuickMultipleEntity.IMG_TEXT,
                        QuickMultipleEntity.IMG_TEXT_SPAN_SIZE_MIN
                    )
                )
            }
            return list
        }
    @JvmStatic
    val delegateMultiItemData: MutableList<DelegateMultiEntity>
        get() {
            val list: MutableList<DelegateMultiEntity> = ArrayList()
            for (i in 0..40) {
                list.add(DelegateMultiEntity())
            }
            return list
        }
    @JvmStatic
    val providerMultiItemData: MutableList<ProviderMultiEntity>
        get() {
            val list: MutableList<ProviderMultiEntity> = ArrayList()
            for (i in 0..40) {
                list.add(ProviderMultiEntity())
            }
            return list
        }
    val diffUtilDemoEntities: MutableList<DiffUtilDemoEntity>
        //
        get() {
            val list: MutableList<DiffUtilDemoEntity> = ArrayList()
            for (i in 0..9) {
                list.add(
                    DiffUtilDemoEntity(
                        i,
                        "Item $i",
                        "This item $i content",
                        "06-12"
                    )
                )
            }
            return list
        }
}
