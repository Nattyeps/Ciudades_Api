package com.example.ciudades_nataliapavan

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

class AppDatabase {
    @Database(entities = [Ciudades::class, User::class], version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun ciudadesDao(): CiudadesDao
        abstract fun userDao(): UserDao

        companion object {
            private const val DATABASE_NAME = "ciudades_database"

            @Volatile
            private var INSTANCE: AppDatabase? = null

            fun getInstance(context: Context): AppDatabase? {
                INSTANCE ?: synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                }
                return INSTANCE
            }
        }
    }

}