package com.example.danp_lab04.entities

import androidx.room.Embedded
import androidx.room.Relation

data class EntityCursoEstudiante(
    @Embedded val entityCurso: EntityCurso,
    @Relation(
        parentColumn = "",
        entityColumn = "",
    )
    val entityEstudiante: EntityEstudiante
)