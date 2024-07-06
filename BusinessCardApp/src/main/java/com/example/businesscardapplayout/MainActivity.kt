package com.example.businesscardapplayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapplayout.ui.theme.BusinessCardAppLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppLayoutTheme {
                Surface (
                    Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                    ){
                    BusinessCardApp()
                }
                }
            }
        }
    }

@Composable
fun BusinessCardApp() {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .padding(top=200.dp)
    ) {
        LogoSection(
            name = stringResource(R.string.name),
            title = stringResource(R.string.title),
            modifier = Modifier.padding()
        )

        ContactInfo(
            phone = "+91-8918500291",
            socialmedia = "@Sujoy00",
            email = "psujoy@gmail.com",
            modifier = Modifier
        )
    }
}


@Composable
fun CardInfo (name: String, title: String, modifier: Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = name,
            fontSize = 36.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 0.dp, end = 0.dp, bottom = 8.dp, top = 8.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = title,
            fontSize = 24.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(start = 0.dp, end = 0.dp, bottom = 8.dp, top = 8.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun LogoSection (name: String, title: String, modifier: Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = "Logo of an android bot",
            contentScale = ContentScale.Fit,
            modifier = modifier
                .height(150.dp)
                .width(250.dp)
        )
        CardInfo(
            name = name,
            title = title,
            modifier = modifier
        )
    }
}

@Composable
private fun ContactInfo (phone: String, socialmedia: String, email: String, modifier: Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Icon(Icons.Rounded.Phone, contentDescription = "Localized description")
            Text(
                text = phone,
                modifier = modifier.padding(bottom = 8.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
        }
        Row {
            Icon(Icons.Rounded.AddCircle, contentDescription = "Localized description")
            Text(
                text = socialmedia,
                modifier = modifier.padding(bottom = 8.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
        }
        Row {
            Icon(Icons.Rounded.Email, contentDescription = "Localized description")
            Text(
                text = email,
                modifier = modifier.padding(bottom = 8.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
        }
    }
}




@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppLayoutTheme {
        BusinessCardApp()
    }
}