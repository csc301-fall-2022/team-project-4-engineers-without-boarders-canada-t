package com.example.missingseven.Screen

import androidx.compose.runtime.Composable
import com.example.missingseven.Component.*
import com.example.missingseven.Model.InstructionUiState
import com.example.missingseven.ViewModel.InstructionViewModel

@Composable
fun InstructionScreen(
    viewModel: InstructionViewModel
){
    InstructionTemplate(
        content = {
            ReadingInstructionBody({}, viewModel.getCurrent() as InstructionUiState.ReadingInstruction)
        },
        viewModel.getPosition(),
        viewModel.getSize(),
        nextHandler = {viewModel.onNextClicked()},
        backHandler = {viewModel.onBackClicked()}
    )
}