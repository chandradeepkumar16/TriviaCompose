package com.example.jettriviacompose.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jettriviacompose.data.DataorException
import com.example.jettriviacompose.model.QuestionItem
import com.example.jettriviacompose.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val repository: QuestionRepository)
    : ViewModel() {
    val data : MutableState<DataorException<ArrayList<QuestionItem>,
            Boolean, Exception>> = mutableStateOf(
        DataorException(null,true,Exception("")) )

    init {
        getAllQuestions()
    }

    private fun  getAllQuestions(){
        viewModelScope.launch {
            data.value.loading=true
            data.value = repository.getAllQuestions()

            if(data.value.data.toString().isNotEmpty()){
                data.value.loading=false
            }
        }
    }

    fun getTotalques(): Int {
        return data.value.data?.toMutableList()?.size!!
    }


}