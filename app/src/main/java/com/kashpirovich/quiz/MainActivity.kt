package com.kashpirovich.quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kashpirovich.quiz.ui.theme.QuizTheme
import kotlinx.coroutines.delay

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
    // TODO 1: Добавить изображения в папку

    // TODO 2: Добавить состояние для хранения текущего значения кубика (1-6)
    // TODO 2 tips - используйте делегат remember и изменяемое состояние (mutable state of)
    var diceValue by remember { mutableStateOf(1) }
    var isRolling by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //TODO 5 Добавить анимацию
        val animatedAlpha by animateFloatAsState(
            targetValue = if (isRolling) 0f else 1f, animationSpec = tween(500), label = ""
        )
        val rotationAngle by animateFloatAsState(
            targetValue = if (isRolling) 360f else 0f, animationSpec = tween(1000), label = ""
        )


        // TODO 3: Показать изображение кубика (использовать Image)
        Image(
            painter = painterResource(id = getDiceImage(diceValue)),
            contentDescription = "Dice with value $diceValue",
            modifier = Modifier
                .size(200.dp)
                .alpha(animatedAlpha)
                .rotate(rotationAngle)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // TODO 4: Добавить кнопку для броска кубика
        Button(onClick = {
            isRolling = true
            diceValue = (1..6).random()
        }) {
            Text("Roll Dice")
        }
        if (isRolling) {
            LaunchedEffect(Unit) {
                delay(1000)
                isRolling = false
            }
        }
    }
}

// TODO 5: Реализовать функцию getDiceImage (возвращает ресурс по числу)
private fun getDiceImage(value: Int): Int {
    return when (value) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}
