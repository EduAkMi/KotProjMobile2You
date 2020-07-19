package com.kaltu.kotprojmobile2you.zMvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.kaltu.kotprojmobile2you.Constants
import com.kaltu.kotprojmobile2you.zModels.Actor
import com.kaltu.kotprojmobile2you.zUtils.Common

class ActorRepository {
    fun getListActors(): MutableLiveData<List<Actor>> {
        val listActorLiveData: MutableLiveData<List<Actor>> = MutableLiveData()
        val actorsRef = Common.actorsCollection.orderBy("nameArtistic")
        actorsRef.get().addOnSuccessListener {
            listActorLiveData.value = it.toObjects(Actor::class.java)
        }.addOnFailureListener {
            Log.d(Constants.APP_DEBUG, "getListActorsFailed: " + it.message)
        }
        return listActorLiveData
    }
}