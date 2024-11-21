package com.example.eveningintents

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat.startActivity
import com.example.eveningintents.ui.theme.EveningIntentsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EveningIntentsTheme {
             HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen(){
    Column(modifier=Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        val context = LocalContext.current
        Button(onClick = {
            val uri = Uri.parse("smsto:+254726314196")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Hello mom")
            startActivity(context,intent,null)
        }) {
            Text(text = "SMS")
        }

        Button(onClick = {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(Activity(),takePictureIntent,1,null )
        }) {
            Text(text = "Camera")
        }

        Button(onClick = {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")
            startActivity(context,Intent.createChooser(emailIntent, "Send email..."),null)
        }) {
            Text(text = "Email")
        }

        Button(onClick = {

        }) {
            Text(text = "Call")
        }

        Button(onClick = {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            shareIntent.setType("text/plain")
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app via https://www.aire.com!")
            startActivity(context,shareIntent,null)
        }) {
            Text(text = "Share")
        }

        Button(onClick = {
            val simToolKitLaunchIntent: Intent = context.getPackageManager().getLaunchIntentForPackage("com.android.stk")!!
            if (simToolKitLaunchIntent != null) {
                startActivity(context,simToolKitLaunchIntent,null)
            }
        }) {
            Text(text = "STK")
            
        }

    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    EveningIntentsTheme {

    }
}