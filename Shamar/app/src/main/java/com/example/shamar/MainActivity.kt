package com.example.shamar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shamar.ui.theme.Purple40
import com.example.shamar.ui.theme.ShamarTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShamarTheme {
                HomeScreen()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}
@Composable
fun HomeScreen(){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Welcome to my App",
            fontSize = 40.sp,
            color = Color.Blue,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Your go to end solution",
            fontSize = 20.sp,
            color = Purple40)


        Spacer(modifier = Modifier.height(20.dp))

        var  name by remember { mutableStateOf(value = "") }
        var  email  by remember { mutableStateOf(value = "") }
        var  password  by remember { mutableStateOf(value = "") }

        OutlinedTextField(
            value ="name",
            onValueChange ={name = it},
            label = { Text(text = "Enter your name")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value =email,
            onValueChange = {email = it},
            label = { Text(text = "Enter email") } ,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value =password,
            onValueChange = {password = it},
            label = { Text(text = "Enter your password") } ,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(20.dp))
Button(onClick = {  })
{
    Text(text = "Register")
    
}
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {  })
        {
            Text(text = "Login")
            
        }


    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ShamarTheme {
        HomeScreen()
    }
}
