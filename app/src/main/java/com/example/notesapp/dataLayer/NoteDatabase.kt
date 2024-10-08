package com.example.notesapp.dataLayer

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.notesapp.utils.UUIDConverter

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase(){
    abstract fun noteDao(): NoteDatabaseDao
}