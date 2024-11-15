package com.github.gunin_igor75.home.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var homeViewModelFactory: HomeViewModel.HomeViewModelFactory.Factory

    private val homeViewModel by viewModels<HomeViewModel> {
        homeViewModelFactory.create(pageId = 100)
    }
}
