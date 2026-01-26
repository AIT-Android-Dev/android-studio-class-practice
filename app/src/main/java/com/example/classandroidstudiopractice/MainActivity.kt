package com.example.classandroidstudiopractice

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
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
                    message = stringResource(R.string.happy_birthday),
                    from = stringResource(R.string.from_text),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
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

        Button(
            onClick = { count++ }
        ) {}
        Text(
            text = count.toString(),
            fontSize = 100.sp,
            lineHeight = 110.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClassAndroidStudioPracticeTheme {
        GreetingImage(
            message = "Happy Birthday",
            from = "From Emir",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier) {
    val image = painterResource(R.drawable.androidparty__1_)

    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
        Greeting(
            message,
            from
        )
    }
}