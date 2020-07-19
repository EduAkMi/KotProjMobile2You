package com.kaltu.kotprojmobile2you.zUtils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.kaltu.kotprojmobile2you.R
import com.kaltu.kotprojmobile2you.zModels.Movies
import com.squareup.picasso.Picasso
import java.util.*

class MoviesAdapter(var context: Context,
    var moviesList: List<Movies>) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_movies, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        Picasso.get().load(moviesList[position].imageUrl).into(holder.imgMovie)

        val calCreation = Calendar.getInstance()
        calCreation.time = moviesList[position].creationDate

        val stringGenres = StringBuilder().append(moviesList[position].genre[0])
        for (genre in 1 until moviesList[position].genre.size)
            stringGenres.append(", ").append(moviesList[position].genre[genre])

        holder.txtName.text = moviesList[position].name
        holder.txtYear.text = calCreation.get(Calendar.YEAR).toString()
        holder.txtGenres.text = stringGenres

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Movie: ${moviesList[position].name}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgMovie: ImageView = itemView.findViewById(R.id.imgRecyclerMovies)
        val txtName: TextView = itemView.findViewById(R.id.txtRecyclerMoviesName)
        val txtYear: TextView = itemView.findViewById(R.id.txtRecyclerMoviesYear)
        val txtGenres: TextView = itemView.findViewById(R.id.txtRecyclerMoviesGenres)
    }
}