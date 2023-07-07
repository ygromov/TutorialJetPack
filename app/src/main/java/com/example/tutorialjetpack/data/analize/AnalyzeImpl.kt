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

        //запрос офпДао и получение ПОСЛЕДНИХ значений
        val responseBD = ofpDao.forCreateTrain()
        val responseBDUser = ofpDao.forCreateTrainUser()

        val exercisePlan: MutableList<TrainingValue> = mutableListOf()
        //Log.d(TAG, "createTrain: $responseBD")

        // Вычисление количества подходов
        // Будет нужно при усложнении генерации тренировочных программ
        val pushUpSets = calculateSets(
            responseBD.push,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height)
        )
        val pullUpSets = calculateSets(
            responseBD.pull,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height)
        )
        val squatSets = calculateSets(
            responseBD.squat,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height)
        )
        val sitUpSets = calculateSets(
            responseBD.abc,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height)
        )

        // Вычисление количества повторений
        val pushUpReps = calculateReps(
            responseBD.push,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )
        val pullUpReps = calculateReps(
            responseBD.pull,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )
        val squatReps = calculateReps(
            responseBD.squat,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )
        val sitUpReps = calculateReps(
            responseBD.abc,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )
        val extensReps = calculateReps(
            responseBD.extens,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )

        exercisePlan.add(
            TrainingValue(
                pushUpSets = pushUpSets,
                pullUpSets = pullUpSets,
                squatSets = squatSets,
                sitUpSets = sitUpSets,

                pushUpReps = pushUpReps,
                pullUpReps = pullUpReps,
                squatReps = squatReps,
                sitUpReps = sitUpReps,
                extensReps = extensReps

            )
        )
        Log.d(TAG, "createTrain: ${exercisePlan[0]}")
        return exercisePlan
    }

    override suspend fun createTwoSetTrain(): List<TrainingValue> {
        val responseBD = ofpDao.forCreateTrain()
        val responseBDUser = ofpDao.forCreateTrainUser()
        val exercisePlan: MutableList<TrainingValue> = mutableListOf()

        var pushUpReps = calculateReps(
            responseBD.push,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )
        var pullUpReps = calculateReps(
            responseBD.pull,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )
        var squatReps = calculateReps(
            responseBD.squat,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )
        var sitUpReps = calculateReps(
            responseBD.abc,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )
        var extensReps = calculateReps(
            responseBD.extens,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )

        pushUpReps = (pushUpReps * 0.9).toInt()
        pullUpReps = (pullUpReps * 0.9).toInt()
        squatReps = (squatReps * 0.9).toInt()
        sitUpReps = (sitUpReps * 0.9).toInt()
        extensReps = (extensReps * 0.9).toInt()

        exercisePlan.add(
            TrainingValue(
                pushUpReps = pushUpReps,
                pullUpReps = pullUpReps,
                squatReps = squatReps,
                sitUpReps = sitUpReps,
                extensReps = extensReps

            )
        )
        return exercisePlan
    }

    override suspend fun createThreeSetTrain(): List<TrainingValue> {
        val responseBD = ofpDao.forCreateTrain()
        val responseBDUser = ofpDao.forCreateTrainUser()
        val exercisePlan: MutableList<TrainingValue> = mutableListOf()

        var pushUpReps = calculateReps(
            responseBD.push,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )
        var pullUpReps = calculateReps(
            responseBD.pull,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )
        var squatReps = calculateReps(
            responseBD.squat,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )
        var sitUpReps = calculateReps(
            responseBD.abc,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )
        var extensReps = calculateReps(
            responseBD.extens,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )

        pushUpReps = (pushUpReps * 0.8).toInt()
        pullUpReps = (pullUpReps * 0.8).toInt()
        squatReps = (squatReps * 0.8).toInt()
        sitUpReps = (sitUpReps * 0.8).toInt()
        extensReps = (extensReps * 0.8).toInt()

        exercisePlan.add(
            TrainingValue(
                pushUpReps = pushUpReps,
                pullUpReps = pullUpReps,
                squatReps = squatReps,
                sitUpReps = sitUpReps,
                extensReps = extensReps

            )
        )
        return exercisePlan
    }

    override suspend fun createFourSetTrain(): List<TrainingValue> {
        val responseBD = ofpDao.forCreateTrain()
        val responseBDUser = ofpDao.forCreateTrainUser()
        val exercisePlan: MutableList<TrainingValue> = mutableListOf()

        var pushUpReps = calculateReps(
            responseBD.push,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )
        var pullUpReps = calculateReps(
            responseBD.pull,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )
        var squatReps = calculateReps(
            responseBD.squat,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )
        var sitUpReps = calculateReps(
            responseBD.abc,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )
        var extensReps = calculateReps(
            responseBD.extens,
            determineExerciseLevel(responseBDUser.weight, responseBDUser.height),
            responseBDUser.age
        )

        pushUpReps = (pushUpReps * 0.75).toInt()
        pullUpReps = (pullUpReps * 0.75).toInt()
        squatReps = (squatReps * 0.75).toInt()
        sitUpReps = (sitUpReps * 0.75).toInt()
        extensReps = (extensReps * 0.75).toInt()

        exercisePlan.add(
            TrainingValue(
                pushUpReps = pushUpReps,
                pullUpReps = pullUpReps,
                squatReps = squatReps,
                sitUpReps = sitUpReps,
                extensReps = extensReps

            )
        )
        return exercisePlan
    }

    fun calculateSets(count: Int, exerciseLevel: ExerciseLevel): Int {
        return when (exerciseLevel) {
            ExerciseLevel.FAT_LOSS -> 3//(count * 0.5).toInt()
            ExerciseLevel.MUSCLE_GAIN -> 5 //(count * 1.5).toInt()
            ExerciseLevel.NORMAL -> 4 //(count * 1.0).toInt()
        }
    }

    fun calculateReps(count: Int, exerciseLevel: ExerciseLevel, age: Int): Int {
        return when (exerciseLevel) {
            ExerciseLevel.FAT_LOSS -> {
                when {
                    age < 30 -> (count * 0.8).toInt() // Молодой возраст
                    age < 50 -> (count * 0.75).toInt() // Средний возраст
                    else -> (count * 0.7).toInt() // Пожилой возраст
                }
            }

            ExerciseLevel.MUSCLE_GAIN -> {
                when {
                    age < 30 -> (count * 0.95).toInt() // Молодой возраст
                    age < 50 -> (count * 0.95).toInt() // Средний возраст
                    else -> (count * 0.9).toInt() // Пожилой возраст
                }
            }

            ExerciseLevel.NORMAL -> {
                when {
                    age < 30 -> (count * 0.9).toInt() // Молодой возраст
                    age < 50 -> (count * 0.9).toInt() // Средний возраст
                    else -> (count * 0.8).toInt() // Пожилой возраст
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
