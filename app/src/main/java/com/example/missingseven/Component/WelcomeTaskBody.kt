package com.example.missingseven.Component

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.missingseven.Model.TaskUiState
import com.example.missingseven.ViewModel.TaskViewModel


@Composable
fun WelcomeTaskBody(
    viewModel: TaskViewModel
) {
    Column {
        AnnotatedClickableText(
            before = "This app supports the purpose of ",
            annotated = "Water for the World Workshops",
            after = " – to introduce the issues surrounding clean drinking water in different" +
                    " parts of the world.") {
            viewModel.welcomeDetailClicked()
        }
        AnnotatedClickableText(
            before = "If you have been asked by your instructor/teacher/presenter to login," +
                    " please complete the ",
            annotated = "LOGIN",
            after = " screen",
            modifier = Modifier.padding(top = 100.dp)) {
            viewModel.loginClicked()
        }
    }
}

@Composable
fun AnnotatedClickableText(
    before: String,
    annotated: String,
    after: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val annotatedText = buildAnnotatedString {
        append(before)

        // We attach this *URL* annotation to the following content
        // until `pop()` is called
        pushStringAnnotation(tag = "click",
            annotation = "click")
        withStyle(style = SpanStyle(
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline)) {
            append(annotated)
        }
        pop()
        append(after)
    }

    ClickableText(
        modifier = modifier,
        text = annotatedText,
        style = TextStyle(
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        ),
        onClick = { offset ->
            // We check if there is an *URL* annotation attached to the text
            // at the clicked position
            annotatedText.getStringAnnotations(tag = "click", start = offset,
                end = offset)
                .firstOrNull()?.let {
                    onClick()
                }
        }
    )
}