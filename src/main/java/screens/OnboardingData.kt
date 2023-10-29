package screens

import screens.Onboarding.sPhoneCodeInput

class OnboardingData {
    val fullText: String = sPhoneCodeInput.getAttribute("content-desc") // Получаем полное значение content-desc
    val regex = """\b\d{4}\b""".toRegex() // Регулярное выражение для поиска четырехзначного числа
    val matchResult = regex.find(fullText)
    val code: String
        get() = matchResult?.value ?: throw Exception("Код не найден!")

    val inputField = ScreenConstructor(
        androidClassName = "//android.view.View[contains(@content-desc, 'Введите код из смс')]",
        elementName = "Код смс"
    )




}

