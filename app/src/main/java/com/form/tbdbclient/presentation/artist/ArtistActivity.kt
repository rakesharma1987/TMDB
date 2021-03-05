package com.form.tbdbclient.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.form.tbdbclient.R
import com.form.tbdbclient.data.model.artist.Artist
import com.form.tbdbclient.databinding.ActivityArtistBinding
import com.form.tbdbclient.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistVieModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var binding : ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)
        artistViewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)
        val responsiveLiveData : LiveData<List<Artist>?> = artistViewModel.getArtist()
        responsiveLiveData.observe(this, Observer {
            Log.i("MyTag:", it.toString())
        })
    }
}