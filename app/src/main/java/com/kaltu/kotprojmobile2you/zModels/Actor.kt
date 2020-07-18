package com.kaltu.kotprojmobile2you.zModels

data class Actor(val id: String,
    val nameFull: String,
    val nameArtistic: String,
    val imageUrl: String,
    val numberLikes: Int,
    val popularity: Int) {
    constructor() : this("", "", "", "", 0, 0)
}