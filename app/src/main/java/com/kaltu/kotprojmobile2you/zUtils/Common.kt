package com.kaltu.kotprojmobile2you.zUtils

import com.google.firebase.firestore.FirebaseFirestore

class Common {
    companion object {
        private val db = FirebaseFirestore.getInstance()
        val actorsCollection = db.collection("Actors")
        val moviesCollection = db.collection("Movies")
    }
}