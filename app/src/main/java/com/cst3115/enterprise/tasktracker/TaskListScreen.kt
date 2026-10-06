package com.cst3115.enterprise.tasktracker

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable

    fun TaskListScreen(
        tasks: List<Task>,
        onAddClick: () -> Unit,
        onDeleteTask: (Task) -> Unit
    ){
      Scaffold(
          topBar = {
              TopAppBar(
                  title = {
                      Text("Task tracker")
                  }
              )
          },

          floatingActionButton = {
              ExtendedFloatingActionButton(
                  onClick = onAddClick,
                  containerColor = MaterialTheme.colorScheme.secondary,
                  contentColor = MaterialTheme.colorScheme.onSecondary
              ) {
                  Text("+ Add task")
              }
          }
      ) { innerPadding ->

          LazyColumn(
              modifier = Modifier
                  .fillMaxSize()
                  .padding(innerPadding),

              contentPadding = PaddingValues(
                  start = 24.dp,
                  end = 24.dp,
                  top = 16.dp,
                  bottom = 100.dp
              ),
              verticalArrangement = Arrangement.spacedBy(16.dp)
          ) {
              item {
                  Column(
                      verticalArrangement = Arrangement.spacedBy(6.dp)
                  ){
                      Text(
                          text = "Your day, organized.",
                          style = MaterialTheme.typography.headlineMedium
                      )

                      Text(
                          text = "${tasks.size} tasks on your list",
                          style = MaterialTheme.typography.bodyMedium,
                          color = MaterialTheme.colorScheme.onSurfaceVariant
                      )
                  }
              }

              if (tasks.isEmpty()){
                  item {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(24.dp),
                            colors= CardDefaults.cardColors(
                                containerColor =
                                    MaterialTheme.colorScheme.primaryContainer
                            )
                        ) {
                            Column(
                                modifier = Modifier.padding(24.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = "A fresh start",
                                    style = MaterialTheme.typography.titleLarge
                                )

                                Text(
                                    text = "Tap Add task to create your first task.",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                        }
                  }
              }


              items(
                  items = tasks,
                  key = { task -> task.id }
              ) { task ->

                  Card(
                      modifier = Modifier.fillMaxWidth(),
                      shape = RoundedCornerShape(20.dp),
                      colors = CardDefaults.cardColors(
                          containerColor =
                              MaterialTheme.colorScheme.surfaceVariant
                      )
                  ){
                      Column(
                          modifier = Modifier.padding(20.dp),
                          verticalArrangement = Arrangement.spacedBy(8.dp)
                      ){
                          Text(
                              text = task.title,
                              style = MaterialTheme.typography.titleLarge
                          )

                          if (task.note.isNotBlank()){
                              Text(
                                  text = task.note,
                                  style = MaterialTheme.typography.bodyMedium
                              )
                          }

                          TextButton(
                              onClick = {
                                  onDeleteTask(task)
                              }
                          ){
                              Text(
                                  text = "Delete",
                                  color = MaterialTheme.colorScheme.error
                              )
                          }
                      }
                  }

              }
          }
      }
    }
