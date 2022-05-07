package com.template

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.template.databinding.ActivityPreviewBinding

lateinit var pBinding: ActivityPreviewBinding

class PreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pBinding = ActivityPreviewBinding.inflate(layoutInflater)
        setContentView(pBinding.root)
        setSupportActionBar(pBinding.toolbar)
        binding.toolbar.elevation = 5F
        val item = intent.getIntExtra("Item", 0)
        Log.d("MOTIONEVENT", "${item}")
        setItems(item)
        pBinding.previewBtn.setOnClickListener { setWallpaper(dataset[item].image) }
    }

    override fun onBackPressed() {
        finish()
    }


    private fun setItems(item: Int) {
        val dataset = LoadData().loadWall()
        pBinding.previewImg.setImageResource(dataset[item].image)
        pBinding.previewTxt.text = dataset[item].name
    }

    override fun onDestroy() {
        Log.d("MOTIONEVENT", "DESTROYVIEW")
        super.onDestroy()
    }

    private fun setWallpaper(img: Int) {
        val image: Bitmap = BitmapFactory.decodeResource(resources, img)
        baseContext.setWallpaper(image)
        Toast.makeText(this, "wallpaper has been changed", Toast.LENGTH_SHORT).show()
    }
}