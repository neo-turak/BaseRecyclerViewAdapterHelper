package com.chad.baserecyclerviewadapterhelper.base

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.chad.baserecyclerviewadapterhelper.R

/**
 * 文 件 名: BaseActivity
 * 创 建 人: Allen
 * 创建日期: 16/12/24 15:33
 * 邮   箱: AllenCoder@126.com
 * 修改时间：
 * 修改备注：
 */
abstract class BaseActivity : AppCompatActivity() {
    /**
     * 日志输出标志getSupportActionBar().
     */
    private var title: TextView? = null
    private var back: ImageView? = null
    protected val TAG: String = this.javaClass.getSimpleName()
    private var rootLayout: LinearLayout? = null
    protected fun setTitle(msg: String?) {
        if (title != null) {
            title!!.text = msg
        }
    }

    /**
     * sometime you want to define back event
     */
    protected fun setBackBtn() {
        if (back != null) {
            back!!.setVisibility(View.VISIBLE)
            back!!.setOnClickListener { finish() }
        } else {
//            Logger.t(TAG).e("back is null ,please check out");
        }
    }

    protected fun setBackClickListener(l: View.OnClickListener?) {
        if (back != null) {
            back!!.setVisibility(View.VISIBLE)
            back!!.setOnClickListener(l)
        } else {
//            Logger.t(TAG).e("back is null ,please check out");
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 经测试在代码里直接声明透明状态栏更有效
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            )
        }
        // 这句很关键，注意是调用父类的方法
        super.setContentView(R.layout.activity_base)
        initToolbar()
    }

    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar?.let { setSupportActionBar(it) }
        if (supportActionBar != null) {
            // Enable the Up button
            supportActionBar!!.setDisplayHomeAsUpEnabled(false)
            supportActionBar!!.setDisplayShowTitleEnabled(false)
        }
        back = findViewById(R.id.img_back)
        title = findViewById(R.id.title)
    }

    override fun setContentView(layoutId: Int) {
        setContentView(View.inflate(this, layoutId, null))
    }

    override fun setContentView(view: View) {
        rootLayout = findViewById(R.id.root_layout)
        if (rootLayout == null) {
            return
        }
        rootLayout!!.addView(
            view,
            ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
        initToolbar()
    }
}
