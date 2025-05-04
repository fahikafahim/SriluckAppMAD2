package com.example.sriluckplatform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.sriluckplatform.navigation.SriluckNavHost
import com.example.sriluckplatform.ui.theme.SriLuckPlatformTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SriLuckPlatformTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SriluckApp()
                }
            }
        }
    }
}

@Composable
fun SriluckApp() {
    val navController = rememberNavController()

    Column(modifier = Modifier.fillMaxSize()) {
        // Main content area
        SriluckNavHost(
            navController = navController
        )

//        // Bottom navigation bar (hidden on login/register screens)
//        val currentRoute = navController.currentBackStackEntry?.destination?.route
//        if (currentRoute != "login" && currentRoute != "register") {
//            BottomBar(navController = navController)
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SriLuckPlatformTheme {
        SriluckApp()
    }
}