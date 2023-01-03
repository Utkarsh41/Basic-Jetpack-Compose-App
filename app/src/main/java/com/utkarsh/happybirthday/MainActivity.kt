package com.utkarsh.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.utkarsh.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android") --> Error
//                    This is function declaration section
                    BirthdayGreetImage("Happy Birthday Utkarsh", "Tripathi")

                }
            }
        }
    }
}
/*
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
*/

@Composable
fun BirthdayGreetImage(msg: String, from: String) {
    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = "Birthday Image",
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop

        )
        BirthDayCard(message = msg, from = from)
    }
}

@Composable
fun BirthDayCard(message: String, from: String) {
    Column {
        Text(
            text = message,
            fontSize = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(start = 16.dp, top = 16.dp)


        )
        Text(
            text = from,
            color = Color.Black,
            fontStyle = FontStyle.Italic,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun BirthdayGreetingWithImagePreview() {
//    Here I have to make changes
    HappyBirthdayTheme {
        BirthdayGreetImage("Happy Birthday Utkarsh!", "-from Tripathi")
    }
}