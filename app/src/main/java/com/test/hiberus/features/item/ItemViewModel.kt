package com.test.hiberus.features.item

import android.os.Bundle
import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner
import com.test.hiberus.domain.model.CardData
import com.test.hiberus.domain.repository.CardRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel @AssistedInject constructor(
    private val cardRepository: CardRepository,
    @Assisted private val handle: SavedStateHandle,
    @Assisted private val id: String
) : ViewModel(){

    var cardData = liveData {
        emit(cardRepository.get(Dispatchers.IO, id))
    }

    @AssistedFactory
    interface AssistedViewModelFactory{
        fun create(
            handle: SavedStateHandle,
            id: String
        ) : ItemViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: AssistedViewModelFactory,
            owner: SavedStateRegistryOwner,
            defaultArgs: Bundle? = null,
            plantId: String
        ): ViewModelProvider.Factory =  object : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

            override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
                return assistedFactory.create(handle, plantId) as T
            }
        }
    }
}