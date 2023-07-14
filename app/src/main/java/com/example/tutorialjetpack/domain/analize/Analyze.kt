package com.example.tutorialjetpack.domain.analize

import com.example.tutorialjetpack.domain.model.TrainingValue

interface Analyze {

    //метод который принимает из БД последние значения ОФП, обрабатывает и возвращает список с данными
    //список по модели(количество подходов и повторений
   suspend fun createTrain(): List<TrainingValue>

   suspend fun createTwoSetTrain() : List<TrainingValue>

    suspend fun createThreeSetTrain() : List<TrainingValue>

    suspend fun createFourSetTrain() : List<TrainingValue>
}