package com.tgLab.tglab_androidtask.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tgLab.tglab_androidtask.R
import com.tgLab.tglab_androidtask.data.models.teamData.TeamDataDataResponse
import kotlinx.android.synthetic.main.adapter_team_data_item.view.*

class TeamDataAdapter: RecyclerView.Adapter<TeamDataAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val dataset: MutableList<TeamDataDataResponse> = mutableListOf()

    fun updateList(newList: List<TeamDataDataResponse>){
        dataset.clear()
        dataset.addAll(newList)
        notifyDataSetChanged()
    }

    fun addAll(list: List<TeamDataDataResponse>){
        dataset.addAll(list)
        notifyDataSetChanged()
    }

    fun getDataset(): List<TeamDataDataResponse> {
        return dataset
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_team_data_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            tv_home_name.text = dataset[position].homeTeam?.name
            tv_home_score.text = dataset[position].homeTeamScore.toString()
            tv_visitor_name.text = dataset[position].visitorTeam?.name
            tv_visitor_score.text = dataset[position].visitorTeamScore.toString()
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}