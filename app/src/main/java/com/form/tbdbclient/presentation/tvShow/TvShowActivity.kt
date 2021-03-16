package com.form.tbdbclient.presentation.tvShow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.form.tbdbclient.R
import com.form.tbdbclient.data.model.TvShow.TvShow
import com.form.tbdbclient.data.model.movie.Movie
import com.form.tbdbclient.databinding.ActivityTvShowBinding
import com.form.tbdbclient.presentation.di.Injector
import com.form.tbdbclient.presentation.movie.MovieAdapter
import com.form.tbdbclient.presentation.movie.MovieViewModel
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowVieModelFactory
    lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var binding : ActivityTvShowBinding
    lateinit var adapter : TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,  R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent().inject(this)
        tvShowViewModel = ViewModelProvider(this, factory).get(TvShowViewModel::class.java)
        initRecyclerView();
    }

    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayTvShows()
    }

    private fun displayTvShows() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData : LiveData<List<TvShow>?> = tvShowViewModel.getTvShow()
        responseLiveData.observe(this, Observer {
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
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
            updateTvShows()
        }

        return super.onOptionsItemSelected(item);
    }

    private fun updateTvShows(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val response : LiveData<List<TvShow>?> = tvShowViewModel.updateTvShow()
        response.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "Data not found", Toast.LENGTH_LONG).show()
            }
        })
    }


}