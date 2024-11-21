package com.example.calculator

import android.os.Bundle
import androidx.Activity.ComponentActivity
import androidx.Activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
     @Composable
     fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                HomeScreen()

               }
            }
        }
    }

@Composable
fun HomeScreen(){
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){
        var answer by remember { mutableStateOf(value = "")}
        Spacer(modifier = Modifier.height(50.dp))
            Text(text = answer)
        Spacer(modifier = Modifier.height(20.dp))
        
        var firstNumber by remember { mutableStateOf(value = "")}
        var secondNumber by remember { mutableStateOf(value = "")}
        
        OutlinedTextField(
            value =firstNumber ,
            onValueChange ={firstNumber=it},
            label = { Text(text = "Enter first number")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        
       Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value =secondNumber ,
            onValueChange ={secondNumber= it},
            label = { Text(text = "Enter second number")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        
        Spacer(modifier = Modifier.height(20.dp))
        Row ( modifier= Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { 
                val result = firstNumber.toDouble() + secondNumber.toDouble()
                answer = result.toString()
            }) {
                Text(text = "Add")
            }
            Button(onClick = { 
                val result = firstNumber.toDouble()-secondNumber.toDouble()
                answer = result.toString()
            }) {
                Text(text = "Subtract")
            }
           
                
            }
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier= Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly{ {
            Button(onClick = {
                val result = firstNumber.toDouble() * secondNumber.toDouble()
                answer = result.toString()
            }) {
                Text(text = "Multiply")
            }
            Button(onClick = {
                val result = firstNumber.toDouble() / secondNumber.toDouble()
                answer = result.toString() 
            }) {
                Text(text = "Divide")
            }
        }
        
        





    }
    




@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CalculatorTheme {
        HomeScreen()
    }
}