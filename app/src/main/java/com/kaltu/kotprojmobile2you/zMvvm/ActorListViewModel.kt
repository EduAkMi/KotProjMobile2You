package com.kaltu.kotprojmobile2you.zMvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kaltu.kotprojmobile2you.zModels.Actor

class ActorListViewModel : ViewModel() {
    private val actorRepository = ActorRepository()
    lateinit var listActorLiveData: MutableLiveData<List<Actor>>

    fun getListActors() {
        listActorLiveData = actorRepository.getListActors()
    }
}