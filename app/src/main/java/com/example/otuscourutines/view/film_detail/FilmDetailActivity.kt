package com.example.otuscourutines.view.film_detail

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.domains.entity.Genre
import com.example.otuscourutines.R
import com.example.otuscourutines.base.BaseActivity
import com.example.otuscourutines.view.main.view.MainActivity.Companion.FILM_ID
import kotlinx.android.synthetic.main.film_detail.*
import javax.inject.Inject

class FilmDetailActivity : BaseActivity<FilmDetailViewModel>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override var layoutId: Int = R.layout.film_detail

    override fun getViewModel(): FilmDetailViewModel {
        return ViewModelProviders.of(this, factory).get(FilmDetailViewModel::class.java)
    }

    override fun setUp() {
        initToolbar()
        initView()
    }

    private fun initView() {
        vModel.getData(intent.getStringExtra(FILM_ID)).observe(this, Observer {
            toolbar.title = it.title
            Glide.with(this).load(it.posterPath).into(ivDetailPoster)
            tvDetailTitle.text = it.title
            tvDetailBudget.text = resources.getString(R.string.budget, it.budget.toString())
            tvDetailGenres.text = getGenres(it.genres).dropLast(2)
            tvDetailOverview.text = it.overView
        })
    }

    private fun getGenres(genres: List<Genre>): String {
        val strBuilder = StringBuilder()
        genres.forEach { strBuilder.append("${it.name}, ") }
        return strBuilder.toString()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }
}