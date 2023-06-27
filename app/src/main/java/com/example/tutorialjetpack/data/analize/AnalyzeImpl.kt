package com.example.tutorialjetpack.data.analize

import android.util.Log
import com.example.tutorialjetpack.data.local.OfpDao
import com.example.tutorialjetpack.domain.model.TrainingValue
import javax.inject.Inject

private const val TAG = "AnalyzeImpl"

class AnalyzeImpl @Inject constructor(
    val ofpDao: OfpDao
) : Analyze {
    override suspend fun createTrain(): List<TrainingValue> {

        //нужен запрос офпДао и получение значений
        val responseBD = ofpDao.forCreateTrain()
        val responseBDUser = ofpDao.forCreateTrainUser()

        val exercisePlan: MutableList<TrainingValue> = mutableListOf()
        //Log.d(TAG, "createTrain: $responseBD")

        // Вычисление количества подходов и повторений
        val pushUpSets = calculateSets(responseBD.push, determineExerciseLevel(responseBDUser.weight, responseBDUser.height))
        val pullUpSets = calculateSets(responseBD.pull, determineExerciseLevel(responseBDUser.weight, responseBDUser.height))
        val squatSets = calculateSets(responseBD.squat, determineExerciseLevel(responseBDUser.weight, responseBDUser.height))
        val sitUpSets = calculateSets(responseBD.abc, determineExerciseLevel(responseBDUser.weight, responseBDUser.height))

        // Вычисление количества повторений
        val pushUpReps = calculateReps(responseBD.push, determineExerciseLevel(responseBDUser.weight, responseBDUser.height), responseBDUser.age)
        val pullUpReps = calculateReps(responseBD.pull, determineExerciseLevel(responseBDUser.weight, responseBDUser.height), responseBDUser.age)
        val squatReps = calculateReps(responseBD.squat, determineExerciseLevel(responseBDUser.weight, responseBDUser.height), responseBDUser.age)
        val sitUpReps = calculateReps(responseBD.abc, determineExerciseLevel(responseBDUser.weight, responseBDUser.height), responseBDUser.age)

        exercisePlan.add(0,TrainingValue(
            pushUpSets=pushUpSets,
            pullUpSets=pullUpSets,
            squatSets =squatSets,
            sitUpSets = sitUpSets,

            pushUpReps = pushUpReps,
            pullUpReps = pullUpReps,
            squatReps = squatReps,
            sitUpReps = sitUpReps

        ))
        Log.d(TAG, "createTrain: ${exercisePlan[0]}")
        return exercisePlan
    }

    fun calculateSets(count: Int, exerciseLevel: ExerciseLevel): Int {
        return when (exerciseLevel) {
            ExerciseLevel.FAT_LOSS -> (count * 0.5).toInt()
            ExerciseLevel.MUSCLE_GAIN -> (count * 1.5).toInt()
            ExerciseLevel.NORMAL -> (count * 1.0).toInt()
        }
    }

    fun calculateReps(count: Int, exerciseLevel: ExerciseLevel, age: Int): Int {
        return when (exerciseLevel) {
            ExerciseLevel.FAT_LOSS -> {
                when {
                    age < 30 -> (count * 1.5).toInt() // Молодой возраст
                    age < 50 -> (count * 1.3).toInt() // Средний возраст
                    else -> (count * 1.1).toInt() // Пожилой возраст
                }
            }

            ExerciseLevel.MUSCLE_GAIN -> {
                when {
                    age < 30 -> (count * 1.8).toInt() // Молодой возраст
                    age < 50 -> (count * 1.5).toInt() // Средний возраст
                    else -> (count * 1.3).toInt() // Пожилой возраст
                }
            }

            ExerciseLevel.NORMAL -> {
                when {
                    age < 30 -> (count * 1.3).toInt() // Молодой возраст
                    age < 50 -> (count * 1.2).toInt() // Средний возраст
                    else -> (count * 1.1).toInt() // Пожилой возраст
                }
            }
        }
    }

    fun determineExerciseLevel(weight: Double, height: Double): ExerciseLevel {
        val bodyMassIndex = weight / (height * height / 10000) // Расчет индекса массы тела (ИМТ)

        return when {
            bodyMassIndex < 18.5 -> ExerciseLevel.MUSCLE_GAIN // Худой человек
            bodyMassIndex > 25 -> ExerciseLevel.FAT_LOSS // Толстый человек
            else -> ExerciseLevel.NORMAL // Обычный человек
        }
    }

    enum class ExerciseLevel {
        FAT_LOSS,
        MUSCLE_GAIN,
        NORMAL
    }
    }
