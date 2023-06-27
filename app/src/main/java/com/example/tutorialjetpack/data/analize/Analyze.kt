package com.example.tutorialjetpack.data.analize

import com.example.tutorialjetpack.domain.model.TrainingValue

interface Analyze {

    //метод который принимает из БД последние значения ОФП, обрабатывает и возвращает список с данными
    //список по модели(количество подходов и повторений
   suspend fun createTrain(

    ): List<TrainingValue>
}