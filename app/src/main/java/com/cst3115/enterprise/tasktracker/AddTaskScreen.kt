package com.cst3115.enterprise.tasktracker

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen (
    onSave: (String, String) -> Unit,
    onBack: () -> Unit
) {
    var title by remember {
        mutableStateOf("")
    }

    var note by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("New Task")
                },

                navigationIcon = {
                    TextButton(onClick = onBack){
                        Text("Back")
                    }
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding)
                .imePadding()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),

            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor =
                        MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "One task at a time",
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Text(
                        text = "Give your task a name and add any useful details.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            OutlinedTextField(
                value = title,

                onValueChange = { newTitle ->
                    title = newTitle
                },

                label = {
                    Text("Task title")
                },

                placeholder = {
                    Text("e.g. Finish my Enterprise Lab 3")
                },

                supportingText = {
                    Text("Required")
                },

                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = note,

                onValueChange = { newNote ->
                    note = newNote
                },

                label = {
                    Text("Note")
                },

                placeholder = {
                    Text("Add any useful details...")
                },

                supportingText = {
                    Text("Optional")
                },

                minLines = 4,
                maxLines = 6,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    onSave(title.trim(), note.trim())
                },

                enabled = title.isNotBlank(),
                shape = RoundedCornerShape(16.dp),

                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text(
                    text = "Save task",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

    }
}
