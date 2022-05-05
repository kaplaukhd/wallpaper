package com.template

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.template.adapter.WallClickListener
import com.template.adapter.WallListener
import com.template.adapter.WallpaperAdapter
import com.template.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding
lateinit var adapter: WallpaperAdapter
lateinit var dataset: ArrayList<WallpaperData>
lateinit var lManager: LinearLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Wallpaper"
        binding.toolbar.elevation = 5F
        lManager = LinearLayoutManager(this)
        dataset = LoadData().loadWall()
        adapter = WallpaperAdapter(this, dataset)

        with(binding) {
            toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            recycler.layoutManager = lManager
            recycler.adapter = adapter
        }
        binding.recycler.doubleWallClick {
            Toast.makeText(this, "${it+1}", Toast.LENGTH_SHORT).show() }
    }

    private inline fun RecyclerView.wallClick(crossinline action: (position: Int) -> Unit) =
        setOnItemClickListener(onClick = action)

    private inline fun RecyclerView.doubleWallClick(crossinline action: (position: Int) -> Unit) =
        setOnItemClickListener(doubleClick = action)

    private inline fun RecyclerView.setOnItemClickListener(
        crossinline onClick: (position: Int) -> Unit = {},
        crossinline doubleClick: (position: Int) -> Unit = {},
    ) {

        addOnItemTouchListener(WallListener(this,
            object : WallClickListener {
                override fun wallClick(view: View, position: Int) {
                    onClick(position)

                }

                override fun doubleWallClick(cView: View, position: Int) {
                    doubleClick(position)

                }

            }))

    }


}