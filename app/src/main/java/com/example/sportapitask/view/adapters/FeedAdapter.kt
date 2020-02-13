package com.example.sportapitask.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sportapitask.R
import com.example.sportapitask.data.models.NetworkFeedModel
import com.example.sportapitask.data.models.domain.FeedModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_feed.*
import kotlinx.android.synthetic.main.item_feed.view.*

class FeedAdapter:RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    private var _feed:ArrayList<FeedModel> = arrayListOf()

    private lateinit var _listener:OnFeedClickListener

    fun loadFeed(feed:ArrayList<FeedModel>){
        _feed = feed
    }

    fun setOnFeedClickListener(listener:OnFeedClickListener){
        _listener = listener
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

        holder.itemView.item_feed_share.setOnClickListener {
            _listener.onShareFeedClicked(_feed[position])
        }

        holder.itemView.item_feed_container.setOnClickListener {
            _listener.onFeedClicked(_feed[position])
        }
    }


    class FeedViewHolder(override val containerView: View?):RecyclerView.ViewHolder(containerView!!),LayoutContainer{
        var feedModel: FeedModel? = null
        set(value) {
            field = value
            tv_item_headline.text = feedModel!!.description
        }
    }

    interface OnFeedClickListener{
        fun onShareFeedClicked(feed:FeedModel)
        fun onFeedClicked(feed: FeedModel)
    }
}