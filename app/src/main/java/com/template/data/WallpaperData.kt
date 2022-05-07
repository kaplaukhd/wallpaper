package com.template

data class WallpaperData(
    val id: Int,
    val image: Int,
    val name: String
)

class LoadData(){
    fun loadWall(): ArrayList<WallpaperData>{
        val wallpapers = ArrayList<WallpaperData>()
        wallpapers.add(WallpaperData(
            1,
            R.drawable.img_seven,
            "Name 1"
        ))
        wallpapers.add(WallpaperData(
            2,
            R.drawable.img_six,
            "Name 2"
        ))
        wallpapers.add(WallpaperData(
            3,
            R.drawable.img_eight,
            "Name 3"
        ))
        wallpapers.add(WallpaperData(
            4,
            R.drawable.img_ten,
            "Name 4"
        ))

        wallpapers.add(WallpaperData(
            5,
            R.drawable.img_eleven,
            "Name 5"
        ))

        wallpapers.add(WallpaperData(
            6,
            R.drawable.img_nine,
            "Name 6"
        ))
        wallpapers.add(WallpaperData(
            7,
            R.drawable.img_spider,
            "Name 7 "
        ))

        return wallpapers
    }
}