package com.example.danp_lab04.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.danp_lab04.entities.EntityEstudiante

@Dao
interface EstudianteDao{
    @Query("select * from estudiante")
    suspend fun getAll(): List<EntityEstudiante>

    @Insert
    suspend fun insert(entityEstudiante: EntityEstudiante)

    @Insert
    suspend fun insert(entityEstudiantes: List<EntityEstudiante>)

    @Delete
    suspend fun delete(entityEstudiante: EntityEstudiante)
}