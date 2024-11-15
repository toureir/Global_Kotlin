package br.com.fiap.alunoresponsavel_rm95849.repository

import br.com.fiap.alunoresponsavel_rm95849.data.Tip
import br.com.fiap.alunoresponsavel_rm95849.data.TipDao
import kotlinx.coroutines.flow.Flow

class TipRepository(private val tipDao: TipDao) {
    val allTips: Flow<List<Tip>> = tipDao.getAllTips()

    suspend fun insert(tip: Tip) {
        tipDao.insert(tip)
    }

    fun searchTips(query: String): Flow<List<Tip>> {
        return tipDao.searchTips("%$query%")
    }
}