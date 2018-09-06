package com.fdxun.witeboard

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class BoardView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val paint = Paint().also {
        it.color = Color.RED
        it.style = Paint.Style.STROKE
        it.strokeWidth = 10.0f
    }
    private val path = Path()

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.v("onTouchEvent", event.toString())
        event?.let {
            val x = it.x
            val y = it.y
            when (it.action) {
                MotionEvent.ACTION_DOWN -> path.moveTo(x, y)
                MotionEvent.ACTION_MOVE -> path.lineTo(x, y)
            }
            invalidate()
        }

        return true
    }

    override fun onDraw(canvas: Canvas?) {
        Log.v("onDraw", canvas.toString())
        canvas?.drawPath(path, paint)
    }

    fun clear(){
        path.reset()
        invalidate()
    }
}