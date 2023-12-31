package com.example.myapplication.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.Background
import com.example.myapplication.ui.theme.LogoBorder
import com.example.myapplication.ui.theme.Onyx
import com.example.myapplication.ui.theme.SkModernist
import com.gowtham.ratingbar.RatingBar

@Composable
fun ScreenHeader(imgHeader: Int, imgLogo: Int, appName: String) {
    Column {
        Image(
            painter = painterResource(id = imgHeader),
            contentDescription = "bg_header",
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp),
            contentScale = ContentScale.Crop,
        )
        Row(modifier = Modifier.padding(start = 24.dp)) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .offset(y = (-24).dp)
                    .border(
                        BorderStroke(2.dp, LogoBorder),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imgLogo),
                    contentDescription = "logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(0.6f)
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(
                    text = appName,
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 26.sp,
                        fontFamily = SkModernist,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        letterSpacing = 0.5.sp,
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RatingBar(
                        value = 5.0f,
                        size = 12.dp,
                        spaceBetween = 2.dp,
                        painterEmpty = painterResource(id = R.drawable.star_background),
                        painterFilled = painterResource(id = R.drawable.star_foreground),
                        onValueChange = {},
                        onRatingChanged = {}
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "70M",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = SkModernist,
                            fontWeight = FontWeight.Normal,
                            color = Onyx,

                            letterSpacing = 0.5.sp,
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenHeaderPreview() {
    Surface(color = Background) {
        ScreenHeader(
            imgHeader = R.drawable.bg_header,
            imgLogo = R.drawable.dota,
            appName = stringResource(id = R.string.dota)
        )
    }
}