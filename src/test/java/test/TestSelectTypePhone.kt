/*
package test

import MainActivity
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit
import screens.Onboarding
import screens.Onboarding.selectTypePhoneCode
import screens.ScreenConstructor
import screens.TestFunctions.clickToElement
import screens.TestFunctions.findElement
import screens.TestFunctions.sendText

class TestSelectTypePhone : MainActivity() {

    @Test
    fun testSelectTypePhone () {
        println("Вводим номер телефона")

        val selectTypePhone = ScreenConstructor(
            androidXPath = "//android.view.View[@content-desc=\\\"Укажите телефон\\n\" +\n" +
                    "                \"На него отправим код подтверждения\\\"]/android.widget.EditText",
            elementName = "Ввод телефона"
        )

        println("Вводим номер телефона")

// вводим номер телефона
        clickToElement(selectTypePhone.androidXPath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(5)

        sendText(selectTypePhone.androidXPath, LocatorType.XPATH)


        // нажимаем кнопку "Получить код"

        try {


            clickToElement(selectTypePhoneCode.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)

        } catch (e: org.openqa.selenium.NoSuchElementException) {
            e.printStackTrace()
            println("Мы поймали ошибку, и теперь тест не упадет")
        }


        // извлекаем код смс

        val sPhoneCodeInput = ScreenConstructor(
            androidXPath = "//android.view.View[contains(@content-desc, 'Введите код из смс')]",
            elementName = "Код смс"
        )

        findElement(sPhoneCodeInput.androidXPath, LocatorType.XPATH)


        // Шаг 2: Извлекаем код из значения атрибута элемента

        val webElement = findElement(sPhoneCodeInput.androidXPath, LocatorType.XPATH)
        val fullText = webElement.getAttribute("content-desc") // Получаем полное значение content-desc
        val regex = """\b\d{4}\b""".toRegex() // Регулярное выражение для поиска четырехзначного числа
        val matchResult = regex.find(fullText.toString())
        val code = matchResult?.value ?: throw Exception("Код не найден!")

        // Шаг 3: Вводим код в поле ввода
        // Находим элемент по его имени класса


        val inputFieldScreen = ScreenConstructor(
            androidClassName = "android.widget.EditText",
            elementName = "Код смс"
        )
        findElement(inputFieldScreen.androidClassName, LocatorType.CLASS_NAME)
        // Вводим код в найденное поле ввода
        sendText(inputFieldScreen.androidClassName, LocatorType.CLASS_NAME)



        clickToElement(Onboarding.sPhoneCodeInput.androidXPath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(5)

        }

}*/
