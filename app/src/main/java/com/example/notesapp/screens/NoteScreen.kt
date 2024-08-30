package com.example.notesapp.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.notesapp.R
import com.example.notesapp.components.AppIcon
import com.example.notesapp.components.InputTextField
import com.example.notesapp.components.NoteButtons
import com.example.notesapp.components.NoteItem
import com.example.notesapp.dataLayer.LocalNotesDataSource
import com.example.notesapp.dataLayer.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {

    val title = remember {
        mutableStateOf("")
    }
    val description = remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopAppBar(
            title = {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AppIcon()
                    Text(
                        text = stringResource(id = R.string.app_name),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TopAppBarDefaults.topAppBarColors(Color(221,0,49))
        )
        HorizontalDivider(thickness = 2.dp, color = Color.Black)
        Spacer(modifier = Modifier.padding(vertical = 40.dp))
        InputTextField(
            textFieldValue = title.value,
            onTextChange = {
                title.value = it
            },
            labelText = stringResource(R.string.title),
            maxLines = 1,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        InputTextField(
            textFieldValue = description.value,
            onTextChange = {
                description.value = it
            },
            labelText = stringResource(R.string.description),
            maxLines = 5,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.padding(25.dp))
        NoteButtons(
            buttonText = stringResource(R.string.save),
            onButtonClick = {
                if (title.value.isNotEmpty() && description.value.isNotEmpty()) {
                    onAddNote(Note(title = title.value, description = description.value))
                    title.value = ""
                    description.value = ""
                    Toast.makeText(context, "Note Added!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        )
        Spacer(modifier = Modifier.padding(10.dp))
        HorizontalDivider(thickness = 2.dp, color = Color.Black)
        Spacer(modifier = Modifier.padding(5.dp))
        LazyColumn (
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
        ) {
            items(notes) {note ->
                NoteItem(
                    noteObject = note,
                    onItemClicked = {
                        onRemoveNote(note)
                        Toast.makeText(context, "Note Removed!", Toast.LENGTH_SHORT)
                            .show()
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(notes = LocalNotesDataSource().getNotesList(), onRemoveNote = {}, onAddNote = {})
}