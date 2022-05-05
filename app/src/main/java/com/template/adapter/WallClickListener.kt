package com.template.adapter

import android.view.View

interface WallClickListener {
    fun wallClick(view: View, position:Int){
    }
    fun doubleWallClick(cView: View, position: Int){}
}