package com.example.lemonadeapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeAppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }

            }
        }
    }
}


@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableStateOf(1) }

    var squeezeCount by remember { mutableStateOf(0) }

    when (currentStep) {
       1 -> {
           LemonTextAndImage(
               textLabelResourceId = R.string.PickLemon,
               drawableResourceId = R.drawable.lemon_tree,
               contentDiscriptionResourceId = R.string.Lemon_tree_content_description,
               onImageClick = {
                   currentStep = 2
                   squeezeCount = (3..6).random()
               }
           )
       }

       2 -> {
           LemonTextAndImage(
               textLabelResourceId = R.string.Squeeze,
               drawableResourceId = R.drawable.lemon_squeeze,
               contentDiscriptionResourceId = R.string.Squeeze_content_description,
               onImageClick = {
                   squeezeCount--
                   if (squeezeCount == 0) {
                       currentStep = 3
                   }
               }
           )
       }

       3 -> {
           LemonTextAndImage(
               textLabelResourceId = R.string.Drink,
               drawableResourceId = R.drawable.lemon_drink,
               contentDiscriptionResourceId = R.string.Drink_content_description,
               onImageClick = {
                   currentStep = 4
               }
           )
       }

       4 -> {
           LemonTextAndImage(
               textLabelResourceId = R.string.ReStart,
               drawableResourceId = R.drawable.lemon_restart,
               contentDiscriptionResourceId = R.string.Restart_content_description,
               onImageClick = {
                   currentStep = 1
               }
           )
       }

    }

}


@Composable
fun LemonTextAndImage( textLabelResourceId: Int,
                           drawableResourceId: Int,
                           contentDiscriptionResourceId: Int,
                           onImageClick: () -> Unit,
                           modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = onImageClick,
            shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)

        ) {
            Image(
                painter = painterResource(drawableResourceId),
                contentDescription = stringResource(contentDiscriptionResourceId),
                modifier = Modifier
                    .width(dimensionResource(R.dimen.button_image_width))
                    .height(dimensionResource(R.dimen.button_image_height))
                    .padding(dimensionResource(R.dimen.button_interior_padding))
            )
        }
        Spacer(modifier = modifier.height(dimensionResource(R.dimen.padding_vertical)))
        Text(
            text = stringResource(textLabelResourceId),
            style = MaterialTheme.typography.bodyLarge
        )
    }

}

@Preview
@Composable
fun LemonPreview() {
    LemonadeAppTheme {
        LemonadeApp()
    }
}
