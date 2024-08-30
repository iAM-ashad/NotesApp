package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.example.notesapp.dataLayer.LocalNotesDataSource
import com.example.notesapp.screens.NoteScreen
import com.example.notesapp.ui.theme.NotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotesAppTheme {
                Surface {
                    NoteScreen(notes = LocalNotesDataSource().getNotesList(), onAddNote = {}, onRemoveNote = {})
                }
            }
        }
    }
}
