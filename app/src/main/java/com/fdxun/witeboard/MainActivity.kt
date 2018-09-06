package com.fdxun.witeboard

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
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
        alertBtn.onClick {
            val boardView = BoardView(this@MainActivity)
            AlertDialog.Builder(this@MainActivity)
                    .setTitle("画板").setView(boardView)
                    .setPositiveButton("确定", null)
                    .setNegativeButton("清除", null)
                    .setNeutralButton("取消") { dialog, which ->
                        dialog.dismiss()
                    }
                    .setCancelable(false)
                    .create().also {
                        it.setOnShowListener {
                            val clearBtn = (it as AlertDialog).getButton(AlertDialog.BUTTON_NEGATIVE)
                            clearBtn.onClick {
                                boardView.clear()
                            }
                        }
                    }.show()
        }
    }
}
