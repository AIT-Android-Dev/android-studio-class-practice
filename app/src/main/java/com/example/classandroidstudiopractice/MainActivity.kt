package com.example.classandroidstudiopractice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.classandroidstudiopractice.ui.theme.ClassAndroidStudioPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        log("onCreate")

        setContent {
            ClassAndroidStudioPracticeTheme {
//                Greeting(
//                    message = stringResource(R.string.happy_birthday),
//                    from = stringResource(R.string.from_text),
//                    modifier = Modifier.padding(8.dp)
//                )
                LogsList(
                    logs,
                    Modifier.padding(8.dp)
                )
            }
        }
    }

    val logs = mutableStateListOf<String>()

    override fun onStart() {
        super.onStart()
        log("onStart")
    }

    override fun onResume() {
        super.onResume()
        log("onResume")
    }

    override fun onStop() {
        super.onStop()
        log("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        log("onDestroy")
    }
    
    fun log(message: String) {
        Log.d("MainActivity", message)
        logs.add(message)
    }
}

@Composable
fun Greeting(message: String, from: String, modifier: Modifier = Modifier) {

    var count by remember { mutableIntStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 110.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )

        Icon(
            imageVector = Icons.Filled.Call,
            contentDescription = null,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClassAndroidStudioPracticeTheme {
        Greeting(
            message = "Happy Birthday",
            from = "From Emir",
            modifier = Modifier.padding(8.dp)
        )
//        LogsList(
//            logs = listOf("Log 1", "Log 2", "Log 3"),
//            modifier = Modifier.padding(8.dp)
//        )
    }
}

@Composable
fun LogsList(logs: List<String>, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        items(logs) { log ->
            Text(text = log)
        }
    }
}