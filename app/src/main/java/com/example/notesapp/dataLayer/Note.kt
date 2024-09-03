package com.example.notesapp.dataLayer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "notes_table")
data class Note (
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "notes_title")
    val title: String,

    @ColumnInfo(name = "notes_description")
    val description: String
)