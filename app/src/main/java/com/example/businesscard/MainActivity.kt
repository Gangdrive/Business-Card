package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ComposeBusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun ComposeBusinessCardApp() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.White)
        ) {
            ComposeBusinessCardTop(
                image = painterResource(R.drawable.ic_inform_sec),
                fullName = stringResource(R.string.full_name)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
            ) {
                ComposeBusinessCardBottom(
                    image = painterResource(R.drawable.ic_phone),
                    imageName = stringResource(R.string.phone_name)
                )

                ComposeBusinessCardBottom(
                    image = painterResource(R.drawable.ic_telegram),
                    imageName = stringResource(R.string.telegram_name)
                )

                ComposeBusinessCardBottom(
                    image = painterResource(R.drawable.ic_mail),
                    imageName = stringResource(R.string.mail_name)
                )
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}

@Composable
fun ComposeBusinessCardTop(image: Painter, fullName: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .padding(top = 180.dp)
        )
        Text(
            text = fullName,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            modifier = modifier
                .padding(16.dp)
        )
        Text(
            text = stringResource(R.string.profession_name),
            fontSize = 20.sp,
        )
    }
}

@Composable
fun ComposeBusinessCardBottom(image: Painter, imageName: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Row {
            Spacer(modifier = Modifier.width(100.dp))
            Image(
                painter = image,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = imageName,
                fontSize = 18.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 5.dp)
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun ComposeBusinessCardPreview() {
    BusinessCardTheme {
        ComposeBusinessCardApp()
    }
}