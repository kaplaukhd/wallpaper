package com.template

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
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

open class MainActivity : AppCompatActivity() {
    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.toolbar.elevation = 5F
        lManager = LinearLayoutManager(this)
        dataset = LoadData().loadWall()
        adapter = WallpaperAdapter(this, dataset)

        with(binding) {
            recycler.layoutManager = lManager
            recycler.adapter = adapter
        }

        binding.recycler.doubleWallClick {
            startDialog(dataset[it].name)
        }

        binding.recycler.singleWallClick {
            val intent = Intent(this, PreviewActivity::class.java)
            intent.putExtra("Item", it)
            startActivity(Intent(intent))
        }
    }


    private inline fun RecyclerView.singleWallClick(crossinline action: (position: Int) -> Unit) =
        setOnItemClickListener(singleClick = action)

    private inline fun RecyclerView.doubleWallClick(crossinline action: (position: Int) -> Unit) =
        setOnItemClickListener(doubleClick = action)

    private inline fun RecyclerView.setOnItemClickListener(
        crossinline singleClick: (position: Int) -> Unit = {},
        crossinline doubleClick: (position: Int) -> Unit = {},
    ) {
        addOnItemTouchListener(WallListener(this,
            object : WallClickListener {
                override fun singleWallClick(cView: View, position: Int) {
                    singleClick(position)
                }

                override fun doubleWallClick(cView: View, position: Int) {
                    doubleClick(position)
                }
            }))

    }

    private fun startDialog(name: String) {
        val nameDialog = AlertDialog.Builder(this)
            .setTitle(name)
            .setPositiveButton("Exit") { _, _ ->
                finish()
            }

        nameDialog.create()
        nameDialog.show()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBackPressed() {

        val randItem = dataset.size * Math.random()
        val item = randItem.toInt()
        Log.d("MOTIONEVENT", "$item")

        val exitDialog = Dialog(this)
        exitDialog.setContentView(R.layout.exit_dialog)
        val exitImg: ImageView = exitDialog.findViewById(R.id.exitImg)
        val setWallBtn = exitDialog.findViewById<Button>(R.id.exitSetWallBtn)
        val exit = exitDialog.findViewById<Button>(R.id.exitBtn)
        exitImg.setImageDrawable(getDrawable(dataset[item].image))
        exitDialog.create()
        exitDialog.show()

        setWallBtn.setOnClickListener {
            val intent = Intent(this, PreviewActivity::class.java)
            intent.putExtra("Item", item)
            startActivity(Intent(intent))
        }
        exit.setOnClickListener {
            finish()
        }

    }


}