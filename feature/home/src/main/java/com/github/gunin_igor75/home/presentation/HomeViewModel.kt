package com.github.gunin_igor75.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.gunin_igor75.core.api.NetworkApi
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
class HomeViewModel @AssistedInject constructor(
    @Assisted(value = "pageId") private val pageId: Int,
    private var networkApi: NetworkApi,
) : ViewModel() {

    @AssistedFactory
    interface Factory{
        fun create(@Assisted(value = "pageId") id: Int): HomeViewModel
    }

    class HomeViewModelFactory @AssistedInject constructor(
        @Assisted(value = "pageId") private val pageId: Int,
        private val homeViewModelProvider: Provider<HomeViewModel.Factory>
    ): ViewModelProvider.Factory{

        @AssistedFactory
        interface Factory {
            fun create(@Assisted(value = "pageId") pageId: Int):HomeViewModelFactory
        }

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return when (modelClass) {
                HomeViewModel::class.java -> {
                    homeViewModelProvider.get().create(pageId)
                }
                else -> throw IllegalArgumentException(
                    "Create ViewModel Error for ${modelClass.name}. " +
                            "ModelClass must be HomeViewModel"
                )
            } as T
        }
    }
}