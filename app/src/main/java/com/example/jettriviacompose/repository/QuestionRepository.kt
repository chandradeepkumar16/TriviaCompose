package com.example.jettriviacompose.repository

import android.util.Log
import com.example.jettriviacompose.data.DataorException
import com.example.jettriviacompose.model.QuestionItem
import com.example.jettriviacompose.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api:QuestionApi) {
    private val dataorException =
        DataorException<ArrayList<QuestionItem>,
                Boolean ,
                Exception>()


    suspend fun getAllQuestions():DataorException<ArrayList<QuestionItem>,Boolean,Exception>{
        try {
            dataorException.loading=true
            dataorException.data=api.getAllQuestions()
            if(dataorException.data.toString().isNotEmpty()) dataorException.loading=false
        }catch (exception:Exception){
            dataorException.e =exception
            Log.d("check", "${dataorException.e!!.localizedMessage}")
        }
        return dataorException
    }
}