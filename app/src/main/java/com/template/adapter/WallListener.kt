package com.template.adapter

import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

class WallListener(private val recycler: RecyclerView, private val listener: WallClickListener?) :
    RecyclerView.OnItemTouchListener {
    private var mGestureDetector: GestureDetector =
        GestureDetector(recycler.context, object : GestureDetector.SimpleOnGestureListener() {

            override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
                val child = e?.let { recycler.findChildViewUnder(it.x, it.y) }
                if (child != null && listener != null) {
                    listener.singleWallClick(child, recycler.getChildAdapterPosition(child))
                    return true
                }
                return false
            }

            override fun onDoubleTap(e: MotionEvent?): Boolean {
                val child = e?.let { recycler.findChildViewUnder(it.x, it.y) }
                if (child != null && listener != null) {
                    listener.doubleWallClick(child, recycler.getChildAdapterPosition(child))
                    return true
                }
                return false
            }


        })

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        Log.d("MOTIONEVENT", "ONCLICK")
        val cView = recycler.findChildViewUnder(e.x, e.y)
        if (cView != null && listener != null && mGestureDetector.onTouchEvent(e)) {
            listener.onClick(cView, recycler.getChildAdapterPosition(cView))
            return false
        }
        return false
    }


    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}
    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
}