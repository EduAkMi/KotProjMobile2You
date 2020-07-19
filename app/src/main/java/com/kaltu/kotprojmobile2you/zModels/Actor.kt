package com.kaltu.kotprojmobile2you.zModels

import java.io.Serializable

data class Actor(val id: String,
    val nameFull: String,
    val nameArtistic: String,
    val imageUrl: String,
    val numberLikes: Int,
    val popularity: Int) : Serializable {
    constructor() : this("", "", "", "", 0, 0)
}