package com.example.missingseven.Screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.missingseven.Component.HeaderView
import com.example.missingseven.ViewModel.TaskViewModel

@Composable
fun WorkshopContactScreen(
    viewModel: TaskViewModel
){
    Column {
        HeaderView(
            header = "Water for the World (W4TW)"
        )
        Text(
            modifier = Modifier.padding(10.dp),
            text = "Workshop are delivered by Engineers Without Borders(EWB) volunteers to school" +
                    " and university students across Canada.Workshops are also available for" +
                    " corporate and community events by contacting W4TW at:"
        )
        DeepLinkText(
            title = "Email: ",
            link = "waterfortheworldworkshops@gmail.com",
            deepLinkEnabled = false
        )
        DeepLinkText(
            title = "Facebook: ",
            link = "www.facebook.com/WaterForTheWorld/")
        DeepLinkText(
            title = "Instagram: ",
            link = "www.instagram.com/water4tworld/?hl=en")
        DeepLinkText(
            title = "Twitter: ",
            link = "twitter.com/EWBWater4World")
        DeepLinkText(
            title = "Website: ",
            link = "waterfortheworldto.wordpress.com/contact/")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { viewModel.navigateBack() }) {
                Text(text = "Back")
            }
        }
    }
}

@Composable
fun DeepLinkText(
    title: String,
    link: String,
    deepLinkEnabled: Boolean = true
){
    val uriHandler = LocalUriHandler.current
    Row(modifier = Modifier.padding(10.dp)) {
        Text(text = title)
        Text(
            text = link,
            modifier = Modifier.clickable {
                if (deepLinkEnabled){
                    uriHandler.openUri("https://$link")
                }
            },
            color = Color.Blue,
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )

    }
}