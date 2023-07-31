package com.example.tutorialjetpack.domain.analize

import com.example.tutorialjetpack.domain.model.OfpGoal
import com.example.tutorialjetpack.domain.model.TrainingValue

interface Analyze {

    //метод который принимает из БД последние значения ОФП, обрабатывает и возвращает список с данными
    //список по модели(количество подходов и повторений
   suspend fun createTrain(): List<TrainingValue>               //create one set of training Programs

   suspend fun createTwoSetTrain() : List<TrainingValue>        //create two set of training Programs

    suspend fun createThreeSetTrain() : List<TrainingValue>     //create three set of training Programs

    suspend fun createFourSetTrain() : List<TrainingValue>      //create four set of training Programs
    suspend fun analizeOfpToGoal() : List<OfpGoal>              //finding user goal in ofp
    suspend fun sumOneTrainPush(number: Int) : Int         //to plus push value to Level value
}