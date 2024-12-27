package com.example.roomproject.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomproject.db.Model.UserEntity
import com.example.roomproject.db.dao.UserDAO
@Database(
    entities = [UserEntity::class],
    version = DBHandler.DATABASE_VERSION
)
abstract class DBHandler:RoomDatabase() {
    abstract fun UserDao():UserDAO

    companion object{
        const val DATABASE_NAME = "main_database"
        const val DATABASE_VERSION = 1
        const val USER_TABLE = "usertable"
        private var INSTANCE:DBHandler? =null
        fun getDatabase(context:Context):DBHandler{
            if(INSTANCE == null)
               INSTANCE =  Room.databaseBuilder(
                    context,
                    DBHandler::class.java,
                    DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
            return INSTANCE!!
        }
    }
}