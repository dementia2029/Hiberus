package com.test.hiberus.features.list

import androidx.lifecycle.*
import com.test.hiberus.domain.model.CardData
import com.test.hiberus.domain.repository.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val cardRepository: CardRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            cardRepository.update(Dispatchers.IO)
        }
    }

    fun getData(): Flow<List<CardData>> = cardRepository.getAll(Dispatchers.IO)
}