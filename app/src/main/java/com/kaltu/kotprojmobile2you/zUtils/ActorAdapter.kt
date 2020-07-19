package com.kaltu.kotprojmobile2you.zUtils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.kaltu.kotprojmobile2you.MainActivity
import com.kaltu.kotprojmobile2you.MainActivity.Companion.fm
import com.kaltu.kotprojmobile2you.R
import com.kaltu.kotprojmobile2you.aMovies.ActorCollection
import com.kaltu.kotprojmobile2you.aMovies.MainHome
import com.kaltu.kotprojmobile2you.zModels.Actor

class ActorAdapter(var context: Context,
    var actorList: List<Actor>) : RecyclerView.Adapter<ActorAdapter.ActorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_actors, parent, false)
        return ActorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.txtNameArtistic.text = actorList[position].nameArtistic
        holder.txtNameFull.text = actorList[position].nameFull
        holder.itemView.setOnClickListener {
            fm.beginTransaction().replace(R.id.fragmentContainerMain, ActorCollection(), null).addToBackStack(null).commit()
        }
    }

    override fun getItemCount(): Int {
        return actorList.size
    }

    class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNameArtistic: TextView = itemView.findViewById(R.id.txtRecyclerActorsNameArtistic)
        val txtNameFull: TextView = itemView.findViewById(R.id.txtRecyclerActorsNameFull)
    }
}