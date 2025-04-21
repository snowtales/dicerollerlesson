package com.kashpirovich.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kashpirovich.quiz.ui.theme.QuizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizTheme {
                DiceRollerScreen()
            }
        }
    }
}

@Composable
fun DiceRollerScreen() {
    // TODO 1: Добавить изображения в папку res/drawables

    // TODO 2: Добавить состояние для хранения текущего значения кубика diceValue с изначальным значением 1
    // TODO 2 tips - используйте делегат remember и изменяемое состояние (mutable state of)
    var diceValue

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        // TODO 2: Показать изображение кубика (использовать Image)


        Spacer(modifier = Modifier.height(32.dp))
    }
}

// TODO 3: Реализовать функцию getDiceImage (возвращает ресурс по числу)
private fun getDiceImage(value: Int): Int {
}
