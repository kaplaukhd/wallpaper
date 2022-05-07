package com.template.adapter

import android.view.View

interface WallClickListener {
    fun onClick(view: View, position:Int){}
    fun doubleWallClick(cView: View, position: Int){}
    fun singleWallClick(cView: View, position: Int){}
}