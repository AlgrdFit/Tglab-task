package com.tgLab.tglab_androidtask.ui.utils

import com.tgLab.tglab_androidtask.ui.home.HomeFragmentDirections
import com.tgLab.tglab_androidtask.ui.players.PlayersFragmentDirections
import com.tgLab.tglab_androidtask.ui.teamData.TeamDataFragmentDirections

object AppRouter {

    fun homeToTeamData(teamIds: Int) =
        HomeFragmentDirections.actionHomeFragmentToTeamDataFragment(teamIds)

    val teamDataToHome = TeamDataFragmentDirections.actionTeamDataFragmentToHomeFragment()
    fun playersToTeamData(teamIds: Int) =
        PlayersFragmentDirections.actionPlayersFragmentToTeamDataFragment(teamIds)
}