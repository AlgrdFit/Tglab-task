package com.tgLab.tglab_androidtask.di

import com.tgLab.tglab_androidtask.data.repo.NBARepository
import com.tgLab.tglab_androidtask.network.NBAApi
import com.tgLab.tglab_androidtask.network.NBAApi.Companion.BASE_URL
import com.tgLab.tglab_androidtask.ui.home.HomeViewModel
import com.tgLab.tglab_androidtask.ui.players.PlayersViewModel
import com.tgLab.tglab_androidtask.ui.teamData.TeamDataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val nbaModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(NBAApi::class.java)
    }
    single {
        NBARepository(get())
    }
    viewModel {
        HomeViewModel(get())
    }
    viewModel{
        PlayersViewModel(get())
    }
    viewModel {
        TeamDataViewModel(get())
    }
}
