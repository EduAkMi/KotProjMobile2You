package com.kaltu.kotprojmobile2you.zMvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.kaltu.kotprojmobile2you.Constants
import com.kaltu.kotprojmobile2you.zModels.Movies
import com.kaltu.kotprojmobile2you.zUtils.Common

class MoviesRepository {
    fun getListMoviesFromActor(actorId: String): MutableLiveData<List<Movies>> {
        val listMoviesFromActor: MutableLiveData<List<Movies>> = MutableLiveData()
        val moviesRef = Common.moviesCollection.whereArrayContains("actorsId", actorId).orderBy("creationDate")
        moviesRef.get().addOnSuccessListener {
            listMoviesFromActor.value = it.toObjects(Movies::class.java)
        }.addOnFailureListener {
            Log.d(Constants.APP_DEBUG, "getListMoviesFailed: " + it.message)
        }
        return listMoviesFromActor
    }
}