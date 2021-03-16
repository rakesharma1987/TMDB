package com.form.tbdbclient.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.form.tbdbclient.R
import com.form.tbdbclient.data.model.TvShow.TvShow
import com.form.tbdbclient.data.model.artist.Artist
import com.form.tbdbclient.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class ArtistAdapter: RecyclerView.Adapter<MyViewHolder>() {
    private val artistList = ArrayList<Artist>()
    fun setList(artist : List<Artist>){
        artistList.clear()
        artistList.addAll(artist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}

class MyViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(artist: Artist){
        binding.titleTextView.text = artist.name
        binding.descriptionTextView.text = artist.popularity.toString()
        val porsterUrl : String = "https://image.tmdb.org/t/p/w500"+artist.profilePath
        Picasso.with(binding.imageView.context)
            .load(porsterUrl)
            .into(binding.imageView)
    }
}