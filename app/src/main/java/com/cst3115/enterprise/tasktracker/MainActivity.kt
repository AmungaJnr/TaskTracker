package com.cst3115.enterprise.tasktracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cst3115.enterprise.tasktracker.ui.theme.TaskTrackerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            TaskTrackerTheme {
                TaskTrackerApp()
            }
        }
    }
}

@Composable
fun TaskTrackerApp() {
    val navController = rememberNavController()

    val tasks = remember {
        mutableStateListOf<Task>()
    }

    val nextTaskId by remember {
        mutableStateOf(1L)
    }

    NavHost(
        navController = navController,
        startDestination = Routes.LIST
    ){
        composable(Routes.LIST){
            TaskListScreen(
                tasks = tasks.toList(),

                onAddClick = {
                    navController.navigate(Routes.ADD)
                },

                onDeleteTask = { task ->
                    tasks.remove(task)
                }
            )
        }

        composable(Routes.ADD) {
            AddTaskScreen(
                onSave = { title, note ->
                    val newTask = Task(
                        id = nextTaskId,
                        title = title,
                        note = note
                    )

                    nextTaskId++
                    tasks.add(newTask)

                    navController.popBackStack()
                },

                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}