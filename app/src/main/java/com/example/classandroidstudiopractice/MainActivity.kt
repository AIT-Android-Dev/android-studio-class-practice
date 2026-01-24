package com.example.classandroidstudiopractice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.classandroidstudiopractice.ui.theme.ClassAndroidStudioPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClassAndroidStudioPracticeTheme {
                Greeting(
                )
            }
        }
    }
}

@Composable
fun Greeting() {

    Log.d("Demo", "Recomposed")

    var count by remember { mutableIntStateOf(0) }
    var name by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Count: $count", modifier =
                Modifier
                    .padding(16.dp)
                    .background(Color.Red)
                    .padding(16.dp)
        )

        Text(
            if (count < 5) "Low" else "High",
            color = Color.Blue,
            fontSize = 24.sp
        )

        Button(onClick = {
            count++
        }) { Text("Count") }

        TextField(
            value = name,
            onValueChange = { text ->
                name = text
            },
            label = { Text("Name") }
        )

        Text("Hello, $name")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClassAndroidStudioPracticeTheme {
        Greeting()
    }
}