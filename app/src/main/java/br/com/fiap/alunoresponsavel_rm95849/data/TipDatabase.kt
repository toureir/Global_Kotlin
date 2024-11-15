package br.com.fiap.alunoresponsavel_rm95849.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tip::class], version = 1, exportSchema = false)
abstract class TipDatabase : RoomDatabase() {
    abstract fun tipDao(): TipDao

    companion object {
        @Volatile
        private var INSTANCE: TipDatabase? = null

        fun getDatabase(context: Context): TipDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TipDatabase::class.java,
                    "tip_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}