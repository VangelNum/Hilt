package com.vangelnum.hilt

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos_table")
data class RoomEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val url: String,
)