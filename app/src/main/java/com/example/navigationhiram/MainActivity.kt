package com.example.navigationhiram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigationhiram.ui.presentation.component.MyAppDrawer
import com.example.navigationhiram.ui.theme.LightColorScheme
import com.example.navigationhiram.ui.theme.NavigationHiramTheme
import com.example.navigationhiram.ui.theme.ThemeType
import com.example.navigationhiram.ui.theme.darkGreenScheme
import com.example.navigationhiram.ui.theme.darkRedScheme
import com.example.navigationhiram.ui.theme.lightGreenScheme
import com.example.navigationhiram.ui.theme.lightRedScheme
import com.example.navigationhiram.utils.conttexto
import com.example.navigationhiram.utils.isNight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/
                val themeType= remember{ mutableStateOf(ThemeType.RED) }
                val darkThemex= isNight()
                val darkTheme = remember { mutableStateOf(darkThemex) }
                val colorScheme=when(themeType.value){
                    ThemeType.RED->{if (darkTheme.value) darkRedScheme else
                        lightRedScheme}
                    ThemeType.GREEN->{if (darkTheme.value) darkGreenScheme else
                        lightGreenScheme}
                    else->{lightGreenScheme}
                }
                conttexto.CONTEXTO_APPX=this
            NavigationHiramTheme(colorScheme = colorScheme) {
                MyAppDrawer(darkMode =darkTheme , themeType = themeType )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationHiramTheme(colorScheme = lightGreenScheme) {
        Greeting("Android")
    }
}