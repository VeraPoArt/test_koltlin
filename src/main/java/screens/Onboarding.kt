package screens

object Onboarding {
    val selectRusButton = ScreenConstructor(
            androidXPath = "//android.view.View[@content-desc=\"Русский\"]",
            elementName = "Выбор русского языка на экране онбординга"
    )

    val nextButton = ScreenConstructor(
            androidAccessibilityId = "Далее",
            elementName = "Кнопка Далее на экране"
    )

    val selectDeliveryButton = ScreenConstructor(
            androidAccessibilityId = "Самовывоз",
            elementName = "Кнопка Самовывоз на экране"
    )
}
