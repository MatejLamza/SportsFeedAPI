package com.example.sportapitask.view.ui.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportapitask.R
import com.example.sportapitask.data.models.domain.FeedModel
import com.example.sportapitask.internal.AutoClearedValue
import com.example.sportapitask.utils.MyConsts
import com.example.sportapitask.view.adapters.FeedAdapter
import com.example.sportapitask.view.ui.VideoActivity
import com.example.sportapitask.viewmodels.FeedViewModel
import com.example.sportapitask.viewmodels.factory.FeedVMFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_feed.*
import javax.inject.Inject

class FragmentFeed : Fragment(), FeedAdapter.OnFeedClickListener {
    @Inject
    lateinit var factory: FeedVMFactory

    private var feed: ArrayList<FeedModel> = arrayListOf()
    private lateinit var feedVM: FeedViewModel
    private var adapter by AutoClearedValue<FeedAdapter>()

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_feed, container, false)
        initRecyclerView(view)

        feedVM = ViewModelProvider(this, factory).get(FeedViewModel::class.java)
        feedVM.getFeed()

        feedVM.spinner.observe(viewLifecycleOwner, Observer { value ->
            value.let { show ->
                load_spinner.visibility = if (show) View.VISIBLE else View.GONE
            }
        })

        feedVM.liveConnection.observe(viewLifecycleOwner, Observer {
            if(!it){
                Toast.makeText(context,MyConsts.CONNECTIVITY_MESSAGE,Toast.LENGTH_LONG).show()
            }
        })

        feedVM.liveFeed.observe(viewLifecycleOwner, Observer {
            feed = it as ArrayList<FeedModel>
            adapter.loadFeed(feed)
            adapter.notifyDataSetChanged()
        })



        return view
    }


    override fun onFeedClicked(feed: FeedModel) {
        val intent = Intent(activity?.applicationContext, VideoActivity::class.java)
        intent.putExtra(MyConsts.EXTRA_VIDEO_MODEL, feed.video)
        startActivity(intent)
    }

    override fun onShareFeedClicked(feed: FeedModel) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, feed.video.url)
            putExtra(Intent.EXTRA_TITLE, "My Awesome Clip")
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    private fun initRecyclerView(view: View) {
        val recyclerView = view.findViewById(R.id.rec_feed) as RecyclerView
        recyclerView.setHasFixedSize(true)
        val manager = LinearLayoutManager(activity!!.applicationContext)
        adapter = FeedAdapter()
        adapter.setOnFeedClickListener(this)
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }
}