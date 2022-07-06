package com.tgLab.tglab_androidtask.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tgLab.tglab_androidtask.R
import com.tgLab.tglab_androidtask.data.models.teams.TeamsDataResponse
import kotlinx.android.synthetic.main.adapter_teams_players_item.view.*

class TeamsAdapter(private val listener: OnClickListener) :
    RecyclerView.Adapter<TeamsAdapter.ViewHolder>() {

    interface OnClickListener {
        fun onClick(teamIds: Int)
    }

    private val dataset: MutableList<TeamsDataResponse> = mutableListOf()

    fun updateList(newList: List<TeamsDataResponse>){
        dataset.clear()
        dataset.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener {
                dataset[adapterPosition].id?.let { id -> listener.onClick(id) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_teams_players_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            tv_firstname_teamname.text = dataset[position].name
            tv_lastname_city.text = dataset[position].city
            tv_teamname_conference.text = dataset[position].conference
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun sort(i: Int) {
        dataset.sortBy {
            when(i){
                1 -> {
                    it.name
                }
                2 -> {
                        it.city
                }
                3 -> {
                        it.conference
                }
                else -> {
                    it.name
                }
            }
        }
        notifyDataSetChanged()
    }
}