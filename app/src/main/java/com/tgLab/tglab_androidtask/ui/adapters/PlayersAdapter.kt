package com.tgLab.tglab_androidtask.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tgLab.tglab_androidtask.R
import com.tgLab.tglab_androidtask.data.models.Players.PlayersDataResponse
import kotlinx.android.synthetic.main.adapter_teams_players_item.view.*

class PlayersAdapter(private val listener: OnClickListener)  :
    RecyclerView.Adapter<PlayersAdapter.ViewHolder>() {

    interface OnClickListener {
        fun onClick(teamIds: Int)
    }

    private val dataset: MutableList<PlayersDataResponse> = mutableListOf()

    fun updateList(newList: List<PlayersDataResponse>){
        dataset.clear()
        dataset.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener {
                dataset[adapterPosition].team?.id?.let { id -> listener.onClick(id) }
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
            //I reused the same layout for Teams
            tv_firstname_teamname.text = dataset[position].firstName
            tv_lastname_city.text = dataset[position].lastName
            tv_teamname_conference.text = dataset[position].team?.name
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}