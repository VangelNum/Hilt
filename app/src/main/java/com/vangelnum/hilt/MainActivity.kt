package com.vangelnum.hilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.vangelnum.hilt.ui.theme.HiltTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MyViewModel by viewModels()
        setContent {
            HiltTheme {
                Navigation(viewModel = viewModel)
            }
        }
    }
}

