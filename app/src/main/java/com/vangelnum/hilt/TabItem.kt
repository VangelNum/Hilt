package com.vangelnum.hilt


sealed class TabItem(var icon: Int, var title: String) {
    object Home : TabItem(R.drawable.ic_baseline_home_24, "home")
    object Favourite : TabItem(R.drawable.ic_baseline_favorite_24, "favourite")
}
