package br.com.fiap.alunoresponsavel_rm95849.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tip_table")
data class Tip(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String
)