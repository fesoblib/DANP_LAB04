package com.example.danp_lab04.model

import com.example.danp_lab04.entities.CursoConEstudiante
import com.example.danp_lab04.entities.EntityCurso
import com.example.danp_lab04.entities.EntityCursoEstudiante
import com.example.danp_lab04.entities.EntityEstudiante

class Repository(private val appDatabase: AppDatabase) {

    suspend fun getAllCursos(): List<EntityCurso>{
        return appDatabase.cursoDao().getAll()
    }

    suspend fun insertCursos(entityCursos: List<EntityCurso>){
        appDatabase.cursoDao().insert(entityCursos)
    }

    suspend fun insertCurso(entityCurso: EntityCurso){
        appDatabase.cursoDao().insert(entityCurso)
    }

    suspend fun getCursoConEstudiante(): List<CursoConEstudiante>{
        return appDatabase.cursoDao().getCursoConEstudiante()
    }

    suspend fun getAllEstudiantes(): List<EntityEstudiante>{
        return appDatabase.estudianteDao().getAll()
    }

    suspend fun insertEstudiantes(entityEstudiante: List<EntityEstudiante>){
        appDatabase.estudianteDao().insert(entityEstudiante)
    }

    suspend fun insertEstudiante(entityEstudiante: EntityEstudiante){
        appDatabase.estudianteDao().insert(entityEstudiante)
    }
}