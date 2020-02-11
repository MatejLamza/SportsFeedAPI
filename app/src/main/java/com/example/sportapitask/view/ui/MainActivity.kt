package com.example.sportapitask.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
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
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var mDrawerLayout:DrawerLayout

    @Inject
    lateinit var factory: FeedVMFactory

    private var feed: ArrayList<NetworkFeedModel> = arrayListOf()

    private lateinit var feedVM: FeedViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: LinearLayoutManager
    private lateinit var adapter: FeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()

        mDrawerLayout = findViewById(R.id.drawer_home)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        feedVM = ViewModelProvider(this,factory).get(FeedViewModel::class.java)

        feedVM.getFeed()

        feedVM.liveFeed.observe(this, Observer {
            feed = it as ArrayList<NetworkFeedModel>
            adapter.loadFeed(feed)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                mDrawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
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
