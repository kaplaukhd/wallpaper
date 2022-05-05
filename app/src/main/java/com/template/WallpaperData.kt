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
            "back"
        ))
        wallpapers.add(WallpaperData(
            2,
            R.drawable.img_six,
            "back2"
        ))
        wallpapers.add(WallpaperData(
            3,
            R.drawable.img_eight,
            "back3"
        ))
        wallpapers.add(WallpaperData(
            4,
            R.drawable.img_ten,
            "back4"
        ))

        wallpapers.add(WallpaperData(
            5,
            R.drawable.img_eleven,
            "back4"
        ))

        wallpapers.add(WallpaperData(
            6,
            R.drawable.img_nine,
            "back4"
        ))
        return wallpapers
    }
}