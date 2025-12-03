package com.utdb.tt2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.utdb.tt2.shared.util.navigation.Navigation
import com.utdb.tt2.ui.theme.UTDBTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp(this@MainActivity)
        }
    }
}


@Composable
fun MyApp(activity: MainActivity) {
    UTDBTheme {
        Navigation(activity)
    }
}
