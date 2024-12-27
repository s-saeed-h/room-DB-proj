package com.example.roomproject.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.roomproject.db.DBHandler
import com.example.roomproject.db.Model.UserEntity
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {
    @Insert
    fun insertUser(vararg users : UserEntity)

    @get:Query("SELECT * FROM ${DBHandler.USER_TABLE}")
    val getUsers : Flow<List<UserEntity>>
    @Update
    fun UpdateUser(vararg users:UserEntity)
    @Delete
    fun DeleteUsers(user:UserEntity)
    @Query("DELETE FROM ${DBHandler.USER_TABLE}")
    fun DeleteAllUsers()
}