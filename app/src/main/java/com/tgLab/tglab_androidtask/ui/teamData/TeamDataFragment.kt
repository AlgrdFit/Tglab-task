package com.tgLab.tglab_androidtask.ui.teamData

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tgLab.tglab_androidtask.R
import com.tgLab.tglab_androidtask.ui.adapters.TeamDataAdapter
import com.tgLab.tglab_androidtask.ui.utils.AppRouter
import kotlinx.android.synthetic.main.fragment_team_data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamDataFragment : BottomSheetDialogFragment() {

    private val teamDataViewModel by viewModel<TeamDataViewModel>()

    private val teamDataAdapter = TeamDataAdapter()

    private val args: TeamDataFragmentArgs by navArgs()

    private var isLoading = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_team_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
        setObservers()
        bindData()
        setListeners()
    }

    private fun setListeners() {
        tv_back_home.setOnClickListener {
            findNavController().navigate(AppRouter.teamDataToHome)
        }
    }

    private fun bindData() {
        teamDataViewModel.getTeamData(args.teamIds)
    }

    private fun setObservers() {
        lifecycleScope.launch(Dispatchers.Main) {
            teamDataViewModel.teamData().observe(viewLifecycleOwner) { response ->
                response.data?.let { it -> teamDataAdapter.updateList(it) }
            }
        }
    }

    private fun setViews() {
        rv_nba_teams_data.apply {
            adapter = teamDataAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (!canScrollVertically(DOWNWARDS_DIRECTION)){
                        isLoading = true
                        Log.d("TeamDataFragment", "--onScrolled adding more data")
                        teamDataAdapter.addAll(teamDataAdapter.getDataset())
                        isLoading = false
                    }
                }
            })
        }
    }
    companion object {
        const val DOWNWARDS_DIRECTION = 1
    }
}