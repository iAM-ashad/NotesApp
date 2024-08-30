package com.example.notesapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesapp.R
import com.example.notesapp.dataLayer.Note

@Composable
fun InputTextField(
   textFieldValue: String,
   onTextChange: (String) -> Unit,
   labelText: String,
   maxLines: Int,
   modifier: Modifier = Modifier
) {
    TextField(
        value = textFieldValue,
        label = {
            Text(text = labelText)
        },
        onValueChange = onTextChange,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        textStyle = TextStyle.Default.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        ),
        maxLines = maxLines,
        modifier = Modifier
            .padding(horizontal = 55.dp, vertical = 10.dp)
            .clip(RoundedCornerShape(topEnd = 25.dp))

    )
}

@Composable
fun NoteButtons(
    buttonText: String,
    onButtonClick: () -> Unit
) {
    Button(
        onClick = onButtonClick,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(Color(69,69,69)),
        elevation = ButtonDefaults.buttonElevation(15.dp),
        modifier = Modifier
            .size(width = 90.dp, height = 45.dp)
    ) {
        Text(text = buttonText, fontSize = 17.sp)
    }
}

@Composable
fun NoteItem(
    noteObject: Note,
    onItemClicked: (Note) -> Unit
) {
    Card (
        shape = RoundedCornerShape(topEnd = 17.dp, bottomStart = 17.dp),
        elevation = CardDefaults.cardElevation(15.dp),
        colors = CardDefaults.cardColors(Color(40,80,46)),
        modifier = Modifier
            .padding(5.dp)
            .fillMaxSize()
            .clickable { onItemClicked(noteObject) }
    ) {
        Text(
            text = noteObject.title,
            color = Color.White,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(5.dp)
        )
        Text(
            text = noteObject.description,
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(5.dp)
        )
    }
}

@Composable
fun AppIcon() {
    Image(
        painter = painterResource(id = R.drawable.app_icon),
        contentDescription = stringResource(R.string.app_icon),
        modifier = Modifier
            .padding(10.dp)
    )
}