package com.example.notesapp.utils

import androidx.room.TypeConverter
import java.util.UUID

class UUIDConverter {
    @TypeConverter
    fun fromUUID(uuid: UUID): String? {
        return uuid.toString()
    }
    fun uuidFromString(string: String?): UUID? {
        return UUID.fromString(string)
    }
}