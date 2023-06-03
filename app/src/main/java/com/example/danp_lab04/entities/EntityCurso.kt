package com.example.danp_lab04.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "curso")
data class EntityCurso(
    @PrimaryKey(autoGenerate = true)
    val cursoId: Int,
    @ColumnInfo(name = "cursoNombre")
    val cursoNombre: String,
    val estudianteId: Int
){
    constructor(cursoNombre: String,estudianteId: Int):this(0,cursoNombre,estudianteId)
}