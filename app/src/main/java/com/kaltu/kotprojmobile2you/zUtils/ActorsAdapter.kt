package com.kaltu.kotprojmobile2you.zUtils

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.kaltu.kotprojmobile2you.MainActivity.Companion.fm
import com.kaltu.kotprojmobile2you.R
import com.kaltu.kotprojmobile2you.aMovies.ActorCollection
import com.kaltu.kotprojmobile2you.zModels.Actor

class ActorsAdapter(private var context: Context,
    private var actorList: List<Actor>) : RecyclerView.Adapter<ActorsAdapter.ActorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_actors, parent, false)
        return ActorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.txtNameArtistic.text = actorList[position].nameArtistic
        holder.txtNameFull.text = actorList[position].nameFull
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("actor", actorList[position])
            val actorCollection = ActorCollection()
            actorCollection.arguments = bundle
            val transaction: FragmentTransaction = fm.beginTransaction()
            transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right)
            transaction.replace(R.id.fragmentContainerMain, actorCollection, null).addToBackStack(null).commit()
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