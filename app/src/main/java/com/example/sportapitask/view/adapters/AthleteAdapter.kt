package com.example.sportapitask.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sportapitask.R
import com.example.sportapitask.data.models.domain.AthleteModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_athlete.view.*

class AthleteAdapter: RecyclerView.Adapter<AthleteAdapter.AthleteViewHolder>() {

    private var _athletes:ArrayList<AthleteModel> = arrayListOf()

    fun loadAthletes(athletes:ArrayList<AthleteModel>){
        _athletes = athletes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AthleteViewHolder =
        AthleteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_athlete,parent,false))

    override fun getItemCount(): Int = _athletes.size

    override fun onBindViewHolder(holder: AthleteViewHolder, position: Int) {
        holder.athleteModel = _athletes[position]

        if(_athletes[position].avatar == null){
            Glide.with(holder.itemView.context)
                .load(R.drawable.avatar_default)
                .into(holder.itemView.item_athlete_icon)
        }

        Glide.with(holder.itemView.context)
            .load(holder.athleteModel!!.avatar)
            .into(holder.itemView.item_athlete_icon)
    }

    class AthleteViewHolder(override val containerView: View?):RecyclerView.ViewHolder(containerView!!),LayoutContainer{
        var athleteModel:AthleteModel? = null
        set(value) {
            field = value

            itemView.tv_item_athlete_name.text = athleteModel?.name
            itemView.tv_item_athlete_country.text = athleteModel?.country?.name
            itemView.tv_item_athlete_sport.text = athleteModel?.sport?.name
            itemView.tv_item_athlete_club.text = athleteModel?.club
        }
    }
}