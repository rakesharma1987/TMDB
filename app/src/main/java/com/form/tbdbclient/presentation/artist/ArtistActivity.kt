package com.form.tbdbclient.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
import com.form.tbdbclient.data.model.artist.Artist
import com.form.tbdbclient.databinding.ActivityArtistBinding
import com.form.tbdbclient.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistVieModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var binding : ActivityArtistBinding
    private lateinit var adapter : ArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)
        artistViewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)
//        val responsiveLiveData : LiveData<List<Artist>?> = artistViewModel.getArtist()
//        responsiveLiveData.observe(this, Observer {
//            Log.i("MyTag:", it.toString())
//        })

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayArtist()
    }

    private fun displayArtist() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData : LiveData<List<Artist>?> = artistViewModel.getArtist()
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
            updateArtist()
        }

        return super.onOptionsItemSelected(item);
    }

    private fun updateArtist(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val response : LiveData<List<Artist>?> = artistViewModel.updateArtist()
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