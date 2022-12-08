package com.example.missingseven.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.missingseven.R

@Preview
@Composable
fun FilterBuildingIntroBody(

){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(Color.White)
    ) {
        Text(
            text = stringResource(id = R.string.task12_content),
            modifier = Modifier.paddingFromBaseline(top =40.dp, bottom = 10.dp),
            fontSize = 18.sp
        )
        Row {
            Column() {
                Text(text = "From this...",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Image(
                    painter = painterResource(R.drawable.dirty_water),
                    contentDescription = "Dirty water",
                    modifier = Modifier.size(130.dp)
                )
            }
            Column() {
                Text(
                    text = "to this...",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Image(
                    painter = painterResource(R.drawable.clean_water),
                    contentDescription = "Clean water",
                    modifier = Modifier.size(130.dp),
                )
            }
        }
        Text(
            text = stringResource(id = R.string.task12_footer),
            modifier = Modifier.paddingFromBaseline(top =40.dp, bottom = 10.dp),
            fontSize = 18.sp
        )
    }
}