package com.example.danp_lab04.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "estudiante")
data class EntityEstudiante(
    @PrimaryKey(autoGenerate = true)
    val estudianteId: Int,
    val estudianteNombres: String,
    val estudianteApellidos: String
)