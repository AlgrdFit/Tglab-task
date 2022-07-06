package com.tgLab.tglab_androidtask.ui.players

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tgLab.tglab_androidtask.R
import com.tgLab.tglab_androidtask.data.models.Players.PlayersDataResponse
import com.tgLab.tglab_androidtask.ui.adapters.PlayersAdapter
import com.tgLab.tglab_androidtask.ui.utils.AppRouter
import kotlinx.android.synthetic.main.fragment_players.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayersFragment : Fragment(R.layout.fragment_players), PlayersAdapter.OnClickListener {


    private val playersViewModel by viewModel<PlayersViewModel>()

    private val teamsAdapter = PlayersAdapter(this)

    private var adapterList = mutableListOf<PlayersDataResponse>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
        setObservers()
        bindData()
        setListeners()
    }

    private fun setListeners() {
        lifecycleScope.launch(Dispatchers.Main){
            et_search.doOnTextChanged { _, _, _, _ ->
                val filter = et_search.text.toString().lowercase().trim()
                val filteredList = adapterList.filter {
                    it.firstName?.lowercase()?.trim()?.contains(filter) ?: false
                }
                teamsAdapter.updateList(filteredList)
            }
        }
    }

    private fun bindData() {
        playersViewModel.getPlayers()
    }

    private fun setViews() {
        rv_nba_players.apply {
            this.adapter = teamsAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun setObservers() {
        lifecycleScope.launch(Dispatchers.Main) {
            playersViewModel.players().observe(viewLifecycleOwner) { response ->
                response.data?.let { it ->
                    teamsAdapter.updateList(it)
                    adapterList.addAll(it)
                }
            }
        }
    }

    override fun onClick(teamIds: Int) {
        findNavController().navigate(AppRouter.playersToTeamData(teamIds))
    }

}