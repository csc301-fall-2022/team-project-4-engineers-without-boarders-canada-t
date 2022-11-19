package com.example.missingseven.Component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.missingseven.Model.TaskUiState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.example.missingseven.Database.Entity.TaskType

@Preview
@Composable
fun ReadingTaskBody(
    completeHandler: (Boolean) -> Unit = {},
    task: TaskUiState.ReadingTask = TaskUiState.ReadingTask(1,
                mutableStateOf(false),
        "Test Reading Title",
        "The @Preview annotation lets you" +
                "package com.example.missingseven.Component\n" +
                "\n" +
                "import androidx.compose.foundation.layout.Column\n" +
                "import androidx.compose.material.Button\n" +
                "import androidx.compose.material.Text\n" +
                "import androidx.compose.runtime.Composable\n" +
                "import androidx.compose.ui.tooling.preview.Preview\n" +
                "import com.example.missingseven.Database.Entity.TaskType" +
                "package com.example.missingseven.Component\n" +
                "\n" +
                "import androidx.compose.foundation.layout.Column\n" +
                "import androidx.compose.material.Button\n" +
                "import androidx.compose.material.Text\n" +
                "import androidx.compose.runtime.Composable\n" +
                "import androidx.compose.ui.tooling.preview.Preview\n" +
                "import com.example.missingseven.Database.Entity.TaskType")
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
//        Text(
//            text = task.header,
//            style = typography.h5,
//            textAlign = TextAlign.Center
//        )
        Text(
            text = task.content,
            modifier = Modifier.paddingFromBaseline(top =40.dp)
        )
//        Button(onClick = { completeHandler()}) {
//            Text(text = "Finished Reading")
//        }
        Row() {
            Checkbox(
                checked = task.completed.value,
                onCheckedChange = {
                    completeHandler(it)},
                enabled = true
            )
            Text(
                text = "Finished Reading",
                modifier = Modifier.padding(15.dp),
                color = Color.Blue
            )
            Spacer(Modifier.weight(1f))
        }

    }
}