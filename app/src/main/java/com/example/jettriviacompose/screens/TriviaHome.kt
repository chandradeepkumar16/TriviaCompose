package com.example.jettriviacompose.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jettriviacompose.component.Questions

@Composable
fun TriviaHome(viewModel:QuestionsViewModel = hiltViewModel()){
    Questions(viewModel)
}