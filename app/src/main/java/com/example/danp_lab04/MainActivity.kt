package com.example.danp_lab04

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.danp_lab04.entities.EntityCurso
import com.example.danp_lab04.entities.EntityEstudiante
import com.example.danp_lab04.model.AppDatabase
import com.example.danp_lab04.model.Repository
import com.example.danp_lab04.ui.theme.DANP_LAB04Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DANP_LAB04Theme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val context = LocalContext.current
                    val repository = Repository(AppDatabase.getInstance(context.applicationContext))

                    RoomSample(repository)

                }
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun RoomSample(repository: Repository) {
    val TAG: String = "RoomDatabase"
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val fillDataOnClick = {
            fillTables(repository, scope)
        }

        val studentsOnClick: () -> Unit = {
            scope.launch {
                repository.getAllCursos().forEach {
                    Log.d(TAG, it.toString())
                }
            }
        }

        val booksOnClick: () -> Unit = {
            scope.launch {
                repository.getAllEstudiantes().forEach {
                    Log.d(TAG, it.toString())
                }
            }
        }

        val studentWithBooksOnClick: () -> Unit = {
            scope.launch {
                repository.getCursoConEstudiante() .forEach {
                    Log.d(TAG, it.toString())
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = fillDataOnClick) {
            Text(text = "Llenar cursos y estudiantes")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = studentsOnClick) {
            Text(text = "Mostrar Cursos")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = booksOnClick) {
            Text(text = "Mostrar Estudiantes")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = studentWithBooksOnClick) {
            Text(text = "Cursos y Estudiantes")
        }

    }
}

fun fillTables(rep: Repository, scope: CoroutineScope) {

    val estudiantes = ArrayList<EntityEstudiante>()

    for (i in 100..120) {
        val entityEstudiante = EntityEstudiante(i,
            estudianteNombres = "Nombres " + i.toString(),
            estudianteApellidos = "Apellidos " + i.toString()
        )
        estudiantes.add(entityEstudiante)
    }

    scope.launch {
        rep.insertEstudiantes(estudiantes)
    }

    for (i in 0..20) {
        val estudianteId = Random.nextInt(100, 120)
        val entityCurso = EntityCurso(cursoNombre = "Curso Nombre " + i.toString(), estudianteId)
        scope.launch {
            rep.insertCurso(entityCurso)
        }

    }


}