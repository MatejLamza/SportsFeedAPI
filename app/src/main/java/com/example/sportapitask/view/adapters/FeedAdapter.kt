package com.example.sportapitask.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sportapitask.R
import com.example.sportapitask.data.models.NetworkFeedModel
import com.example.sportapitask.data.models.domain.FeedModel
import kotlinx.android.synthetic.main.item_feed.view.*

class FeedAdapter:RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    private var _feed:ArrayList<FeedModel> = arrayListOf()

    fun loadFeed(feed:ArrayList<FeedModel>){
        _feed = feed
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder =
        FeedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_feed,parent,false))

    override fun getItemCount(): Int = _feed.size

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.feedModel = _feed[position]

        Glide
            .with(holder.itemView.context)
            .load(holder.feedModel!!.video.poster)
            .into(holder.itemView.iv_item_background)
    }

    class FeedViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var feedModel: FeedModel? = null
        set(value) {
            field = value

            itemView.tv_item_headline.text = feedModel!!.description
        }
    }
}