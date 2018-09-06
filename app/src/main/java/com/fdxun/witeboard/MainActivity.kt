package com.fdxun.witeboard

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.com.gmcc.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clearBtn.onClick {
            boardView.clear()
        }
    }
}
