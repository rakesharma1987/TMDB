package com.form.tbdbclient.presentation.tvShow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.form.tbdbclient.R
import com.form.tbdbclient.data.model.TvShow.TvShow
import com.form.tbdbclient.data.model.movie.Movie
import com.form.tbdbclient.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class TvShowAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val tvShowList = ArrayList<TvShow>()
    fun setList(tvShow : List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(tvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}

class MyViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(tvShow : TvShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val porsterUrl : String = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
        Picasso.with(binding.imageView.context)
                .load(porsterUrl)
                .into(binding.imageView)
    }
}