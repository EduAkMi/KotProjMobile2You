package com.kaltu.kotprojmobile2you.zModels

import java.util.*

data class Movies(val id: String,
    val name: String,
    val imageUrl: String,
    val creationDate: Date,
    val genre: List<String>,
    val actors: List<String>,
    val actorsId: List<String>) {
    constructor() : this("", "", "", Date(0), listOf(""), listOf(""), listOf(""))
}