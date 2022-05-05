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
            R.drawable.ic_launcher_background,
            "back"
        ))
        wallpapers.add(WallpaperData(
            2,
            R.drawable.ic_launcher_background,
            "back2"
        ))
        wallpapers.add(WallpaperData(
            3,
            R.drawable.ic_launcher_background,
            "back3"
        ))
        wallpapers.add(WallpaperData(
            4,
            R.drawable.ic_launcher_background,
            "back4"
        ))
        return wallpapers
    }
}