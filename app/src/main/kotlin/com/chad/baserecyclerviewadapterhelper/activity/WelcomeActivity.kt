package com.chad.baserecyclerviewadapterhelper.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.chad.baserecyclerviewadapterhelper.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@WelcomeActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }
}
