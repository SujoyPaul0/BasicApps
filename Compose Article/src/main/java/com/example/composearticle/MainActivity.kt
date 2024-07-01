package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JetpackComposeImage(
                        heading = stringResource(R.string.jetpack_compose_heading),
                        paragraph1 = stringResource(R.string.jetpack_compose_paragraph1),
                        paragraph2 = stringResource(R.string.jetpack_compose_paragraph2),
                        modifier = Modifier.padding( start = 0.dp, end = 0. dp, bottom = 0. dp, top = 44. dp)
                    )
                }
            }
        }
    }
}

@Composable
fun JetpackComposeText(heading: String, paragraph1: String, paragraph2: String, modifier: Modifier) {
    Column (
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
    ) {
        Text(
            text = heading,
            fontSize = 24.sp,
            lineHeight = 24.sp,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 20.dp)
                .align(alignment = Alignment.CenterHorizontally)

        )
        Text(
            text = paragraph1,
            fontSize = 20.sp,
            lineHeight = 24.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 20.dp)

        )
        Text(
            text = paragraph2 ,
            fontSize = 20.sp,
            lineHeight = 24.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 20.dp)
        )
    }
}

@Composable
fun JetpackComposeImage(heading: String, paragraph1: String, paragraph2: String, modifier: Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,


        )
        JetpackComposeText(
            heading = heading,
            paragraph1 = paragraph1,
            paragraph2 = paragraph2,
            modifier = Modifier
        )
    }

}

@Preview(showBackground = true)
@Composable
fun JetComposePreview() {
    ComposeArticleTheme {
        JetpackComposeImage(heading = stringResource(R.string.jetpack_compose_heading),
            paragraph1 = stringResource(R.string.jetpack_compose_paragraph1),
            paragraph2 = stringResource(R.string.jetpack_compose_paragraph2),
            modifier = Modifier)
    }
}