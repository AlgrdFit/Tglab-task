package com.tgLab.tglab_androidtask.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tgLab.tglab_androidtask.R
import com.tgLab.tglab_androidtask.ui.adapters.TeamsAdapter
import com.tgLab.tglab_androidtask.ui.utils.AppRouter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home), TeamsAdapter.OnClickListener {

    private val homeViewModel by viewModel<HomeViewModel>()

    private val teamsAdapter = TeamsAdapter(this)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
        setObservers()
        bindData()
        setListeners()
    }

    private fun setListeners() {
        btn_sorter.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Choose by what to order")
                .setSingleChoiceItems(
                    arrayOf(
                        resources.getString(R.string.no_sort),
                        tv_name.text.toString(),
                        tv_city.text.toString(),
                        tv_team.text.toString()
                    ), 0
                ) { dialog, i ->
                    setButtonTitle(i)
                    teamsAdapter.sort(i)
                    dialog.dismiss()
                }.show()
        }
    }

    private fun setButtonTitle(i: Int){
        when(i){
            0 -> {
                btn_sorter.setText(R.string.no_sort)
            }
            1 -> {
                btn_sorter.setText(R.string.name)
            }
            2 -> {
                btn_sorter.setText(R.string.city)
            }
            3 -> {
                btn_sorter.setText(R.string.team)
            }
        }
    }

    private fun bindData() {
        homeViewModel.getTeams()
    }

    private fun setViews() {
        rv_nba_teams_data.apply {
            this.adapter = teamsAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun setObservers() {
        lifecycleScope.launch(Dispatchers.Main) {
            homeViewModel.teams().observe(viewLifecycleOwner) { response ->
                Log.d("homeFragment", "Clicked for setObservers()")
                response.data?.let { it -> teamsAdapter.updateList(it) }
            }
        }
    }

    override fun onClick(teamIds: Int) {
        findNavController().navigate(AppRouter.homeToTeamData(teamIds))
    }
}