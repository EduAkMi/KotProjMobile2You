package com.kaltu.kotprojmobile2you.zMvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kaltu.kotprojmobile2you.zModels.Movies

class MoviesListViewModel : ViewModel() {
    private val moviesRepository = MoviesRepository()
    lateinit var listMoviesFromActorLiveData: MutableLiveData<List<Movies>>

    fun getListMoviesFromActor(actorId: String) {
        listMoviesFromActorLiveData = moviesRepository.getListMoviesFromActor(actorId)
    }
}