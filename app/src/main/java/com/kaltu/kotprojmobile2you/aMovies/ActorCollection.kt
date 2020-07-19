package com.kaltu.kotprojmobile2you.aMovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kaltu.kotprojmobile2you.MainActivity
import com.kaltu.kotprojmobile2you.R
import com.kaltu.kotprojmobile2you.zModels.Actor
import com.kaltu.kotprojmobile2you.zMvvm.MoviesListViewModel
import com.kaltu.kotprojmobile2you.zUtils.MoviesAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_actor_collection.*

class ActorCollection : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_actor_collection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentActor = arguments!!.get("actor") as Actor

        Picasso.get().load(currentActor.imageUrl).into(imgActorCollection)
        txtActorCollectionName.text = currentActor.nameArtistic
        txtActorCollectionLikes.text = formatNumber(currentActor.numberLikes)
        txtActorCollectionPopularity.text = formatNumber(currentActor.popularity)

        recyclerActorCollection.layoutManager = LinearLayoutManager(context)
        val moviesViewModel = ViewModelProvider(activity!!).get<MoviesListViewModel>(MoviesListViewModel::class.java)
        moviesViewModel.getListMoviesFromActor(currentActor.id)
        moviesViewModel.listMoviesFromActorLiveData.observe(viewLifecycleOwner, Observer {
            val moviesAdapter = MoviesAdapter(context!!, it)
            recyclerActorCollection.adapter = moviesAdapter
            moviesAdapter.notifyDataSetChanged()
        })

        imgActorCollectionBack.setOnClickListener {
            MainActivity.fm.popBackStack()
        }
        imgActorCollectionFavorite.setOnClickListener {
            if (imgActorCollectionFavorite.drawable.constantState == resources.getDrawable(R.drawable.ic_favorite_border_white_20).constantState)
                imgActorCollectionFavorite.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_white_20))
            else
                imgActorCollectionFavorite.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_border_white_20))
        }
    }

    private fun formatNumber(numberLikes: Int): CharSequence? {
        val stringBuilder = StringBuilder()
        when {
            numberLikes < 1000 -> stringBuilder.append(numberLikes)
            numberLikes < 10000 -> stringBuilder.append(numberLikes / 1000).append(".").append((numberLikes / 100) % 10).append("K")
            numberLikes < 1000000 -> stringBuilder.append(numberLikes / 1000).append("K")
            numberLikes < 10000000 -> stringBuilder.append(numberLikes / 1000000).append(".")
                .append((numberLikes / 100000) % 10).append("M")
            else -> stringBuilder.append(numberLikes / 1000000).append("M")
        }
        return stringBuilder
    }
}