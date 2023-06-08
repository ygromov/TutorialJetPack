package com.example.tutorialjetpack.data.local.converter

import androidx.room.TypeConverter
import java.util.Date

class TimeStamp {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}
//error commit