package com.example.sportapitask.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportapitask.R
import com.example.sportapitask.data.models.NetworkFeedModel
import com.example.sportapitask.view.adapters.FeedAdapter
import com.example.sportapitask.viewmodels.FeedViewModel
import com.example.sportapitask.viewmodels.factory.FeedVMFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class ActivityFeed:AppCompatActivity() {

    @Inject
    lateinit var factory:FeedVMFactory

    private var feed: ArrayList<NetworkFeedModel> = arrayListOf()

    private lateinit var feedVM:FeedViewModel
    private lateinit var recyclerView:RecyclerView
    private lateinit var manager:LinearLayoutManager
    private lateinit var adapter:FeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        initRecyclerView()

        feedVM = ViewModelProvider(this,factory).get(FeedViewModel::class.java)

        feedVM.getFeed()

    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.rec_feed)
        recyclerView.setHasFixedSize(true)

        manager = LinearLayoutManager(this)
        adapter = FeedAdapter()
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }
}