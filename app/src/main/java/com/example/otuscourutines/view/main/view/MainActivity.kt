package com.example.otuscourutines.view.main.view

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.otuscourutines.R
import com.example.otuscourutines.base.BaseActivity
import com.example.otuscourutines.view.film_detail.FilmDetailActivity
import com.example.otuscourutines.view.main.adapter.FilmsAdapter
import com.example.otuscourutines.view.mapper.Mapper
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    @Inject
    lateinit var mapper: Mapper

    lateinit var adapter: FilmsAdapter

    override var layoutId = R.layout.activity_main

    override fun getViewModel(): MainViewModel {
        return ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
    }

    override fun setUp() {
        adapter = FilmsAdapter(::itemClick)
        rvFilmsContainer.adapter = adapter
        vModel.getData().observe(this, Observer {
            adapter.replace(mapper.mapFilmsToPostModel(it))
        })
    }

    private fun itemClick(id: String) {
        startActivity(Intent(this, FilmDetailActivity::class.java).apply {
            putExtra(FILM_ID, id)
        })
    }

    companion object {
        const val FILM_ID = "film_id"
    }
}
