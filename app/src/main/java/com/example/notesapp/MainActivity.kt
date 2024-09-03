package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notesapp.model.NoteScreenViewModel
import com.example.notesapp.screens.NoteScreen
import com.example.notesapp.ui.theme.NotesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesAppTheme {
                Surface {
                    val noteViewModel = viewModel<NoteScreenViewModel>()
                    NotesApp(noteViewModel)
                }
            }
        }
    }
}

@Composable
fun NotesApp(noteViewModel: NoteScreenViewModel) {

    val notesList = noteViewModel.notesList.collectAsState().value

    NoteScreen(
        notes = notesList,
        onAddNote = {noteViewModel.addNote(it)},
        onRemoveNote = {noteViewModel.removeNote(it)}
    )

}