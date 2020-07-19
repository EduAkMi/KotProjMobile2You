package com.kaltu.kotprojmobile2you.aMovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kaltu.kotprojmobile2you.R
import com.kaltu.kotprojmobile2you.zMvvm.ActorsListViewModel
import com.kaltu.kotprojmobile2you.zUtils.ActorsAdapter
import kotlinx.android.synthetic.main.fragment_main_home.*

class MainHome : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerHome.layoutManager = LinearLayoutManager(context)
        val actorViewModel = ViewModelProvider(activity!!).get<ActorsListViewModel>(ActorsListViewModel::class.java)
        actorViewModel.getListActors()
        actorViewModel.listActorLiveData.observe(viewLifecycleOwner, Observer {
            val actorAdapter = ActorsAdapter(context!!, it)
            recyclerHome.adapter = actorAdapter
            actorAdapter.notifyDataSetChanged()
        })
    }
}