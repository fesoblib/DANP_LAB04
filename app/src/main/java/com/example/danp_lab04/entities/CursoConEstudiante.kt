package com.example.danp_lab04.entities

import androidx.room.Embedded
import androidx.room.Relation

data class CursoConEstudiante (
    @Embedded val entityCurso: EntityCurso,
    @Relation(
        parentColumn = "cursoId",
        entityColumn = "estudianteId"
    )
    val entityEstudiante: List<EntityEstudiante>
)