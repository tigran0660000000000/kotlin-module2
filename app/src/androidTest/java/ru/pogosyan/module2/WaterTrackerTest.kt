package ru.pogosyan.module2

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

// Задание 9. UI-тесты для трекера воды из задания 8
@RunWith(AndroidJUnit4::class)
class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            Module2Theme {
                WaterTracker()
            }
        }
    }

    private fun addWater(times: Int) {
        repeat(times) { composeTestRule.onNodeWithText("+250 мл").performClick() }
    }

    // 1) Кнопка добавления жидкости есть и увеличивает счётчик на 250 мл
    @Test
    fun addWaterButton_existsAndAdds250() {
        composeTestRule.onNodeWithText("+250 мл").assertIsDisplayed()
        composeTestRule.onNodeWithTag("waterCount").assertTextEquals("0 мл")
        addWater(1)
        composeTestRule.onNodeWithTag("waterCount").assertTextEquals("250 мл")
        addWater(2)
        composeTestRule.onNodeWithTag("waterCount").assertTextEquals("750 мл")
    }

    // 2) Кнопка «Завершить день» есть и сбрасывает счётчик воды до нуля
    @Test
    fun finishDayButton_existsAndResetsWater() {
        composeTestRule.onNodeWithText("Завершить день").assertIsDisplayed()
        addWater(3)
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithTag("waterCount").assertTextEquals("0 мл")
    }

    // 3) Текст с количеством дней подряд: растёт при норме и обнуляется при недоборе
    @Test
    fun daysInRowText_countsAndResets() {
        composeTestRule.onNodeWithTag("daysInRow")
            .assertIsDisplayed()
            .assertTextEquals("Дней подряд с нормой 1500 мл: 0")

        addWater(6)
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithTag("daysInRow").assertTextEquals("Дней подряд с нормой 1500 мл: 1")

        addWater(7)
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithTag("daysInRow").assertTextEquals("Дней подряд с нормой 1500 мл: 2")

        addWater(2)
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithTag("daysInRow").assertTextEquals("Дней подряд с нормой 1500 мл: 0")
    }
}
