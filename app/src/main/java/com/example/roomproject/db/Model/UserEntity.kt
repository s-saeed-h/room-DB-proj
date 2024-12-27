package com.example.roomproject.db.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.roomproject.db.DBHandler

@Entity(tableName = DBHandler.USER_TABLE)

data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo() val name:String,
    @ColumnInfo() val family:String,
    @ColumnInfo() val phon:String,
    @ColumnInfo() val age:Int
)
