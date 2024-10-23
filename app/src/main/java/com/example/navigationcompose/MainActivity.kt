package com.example.navigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationcompose.ui.theme.NavigationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavigationComposeTheme {
                NavHost(
                    navController = navController,
                    startDestination = "Screen_1"
                ) {
                    composable("Screen_1"){
                        Screen1 { navController.navigate("Screen_2") }
                    }
                    composable("Screen_2"){
                        Screen2 { navController.navigate("Screen_3") }
                    }
                    composable("Screen_3"){
                        Screen3 {
                            navController.navigate("Screen_1") {
                                popUpTo("Screen_1") {
                                    inclusive = true
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}