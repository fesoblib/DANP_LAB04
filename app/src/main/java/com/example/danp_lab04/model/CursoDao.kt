package com.example.danp_lab04.model

import androidx.room.*
import com.example.danp_lab04.entities.CursoConEstudiante
import com.example.danp_lab04.entities.EntityCurso

@Dao
interface CursoDao{
    @Query("select * from curso")
    suspend fun getAll(): List<EntityCurso>

    @Transaction
    @Query("select * from curso")
    suspend fun getCursoConEstudiante():List<CursoConEstudiante>

    @Insert
    suspend fun insert(entityCurso: EntityCurso)

    @Insert
    suspend fun insert(entityCursos: List<EntityCurso>)

    @Delete
    suspend fun delete(entityCurso: EntityCurso)
}