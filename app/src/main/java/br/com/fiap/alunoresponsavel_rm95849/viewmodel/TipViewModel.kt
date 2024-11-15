package br.com.fiap.alunoresponsavel_rm95849.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import br.com.fiap.alunoresponsavel_rm95849.data.Tip
import br.com.fiap.alunoresponsavel_rm95849.data.TipDatabase
import br.com.fiap.alunoresponsavel_rm95849.repository.TipRepository
import kotlinx.coroutines.launch

class TipViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TipRepository
    val allTips: LiveData<List<Tip>>

    // Adicionando searchResults
    private val _searchResults = MutableLiveData<List<Tip>>()
    val searchResults: LiveData<List<Tip>> = _searchResults

    init {
        val tipDao = TipDatabase.getDatabase(application).tipDao()
        repository = TipRepository(tipDao)
        allTips = repository.allTips.asLiveData()
    }

    fun insert(tip: Tip) = viewModelScope.launch {
        repository.insert(tip)
    }

    fun searchTips(query: String) = viewModelScope.launch {
        repository.searchTips(query).collect { tips ->
            _searchResults.value = tips
        }
    }
}