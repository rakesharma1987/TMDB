package com.form.tbdbclient.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Switch
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.form.tbdbclient.R
import com.form.tbdbclient.data.model.movie.Movie
import com.form.tbdbclient.databinding.ActivityMovieBinding
import com.form.tbdbclient.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding : ActivityMovieBinding
    private lateinit var adaper : MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubComponenet().inject(this)
        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)
        /*val responseLiveData : LiveData<List<Movie>?> = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            Log.i("MyTag:", it.toString())
        })*/
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adaper = MovieAdapter()
        binding.movieRecyclerView.adapter = adaper
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData : LiveData<List<Movie>?> = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if (it != null){
                adaper.setList(it)
                adaper.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Found.", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        if(id == R.id.action_update){
            updateMovies()
        }

        return super.onOptionsItemSelected(item);
    }

    private fun updateMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val response : LiveData<List<Movie>?> = movieViewModel.updateMovies()
        response.observe(this, Observer {
            if (it!=null){
                adaper.setList(it)
                adaper.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "Data not found", Toast.LENGTH_LONG).show()
            }
        })
    }
}