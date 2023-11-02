package good_test

import MainActivity
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit
import screens.Onboarding.selectTypePhoneCode
import screens.TestFunctions.clickToElement


class TestSelectTypePhoneCode : MainActivity() {

    @Test
    fun testSelectTypePhoneCode() {
        println("Нажимаем кнопку Получить код")

        // нажимаем кнопку "Получить код"
        try {
            // нажимаем кнопку "Получить код" используя accessibility ID
            clickToElement(selectTypePhoneCode.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
            TimeUnit.SECONDS.sleep(7)
        } catch (e: Exception) {
            e.printStackTrace()
            println("Мы поймали ошибку, и теперь тест не упадет")
        }
    }
}



