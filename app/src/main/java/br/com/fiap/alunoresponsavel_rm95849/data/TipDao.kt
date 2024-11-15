package br.com.fiap.alunoresponsavel_rm95849.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TipDao {
    @Query("SELECT * FROM tip_table")
    fun getAllTips(): Flow<List<Tip>>

    @Insert
    suspend fun insert(tip: Tip)

    @Query("SELECT * FROM tip_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchTips(searchQuery: String): Flow<List<Tip>>
}