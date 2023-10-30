package screens

import io.appium.java_client.AppiumBy

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

    val selectAddress = ScreenConstructor(
            androidAccessibilityId = "Shop 1\\n\" +\n" +
                    "//                \"Невский проспект 37",
            elementName = "Выбор адреса"
    )

    val selectPromo = ScreenConstructor(
            androidAccessibilityId = "Встречайте новинку: Пепперони с чили",
            elementName = "Проверка акции с пепперони"
    )

    val selectSnacks = ScreenConstructor(
        androidAccessibilityId = "Закуски",
        elementName = "Выбор закусок"
    )

    val selectTypePhone = ScreenConstructor(
        androidXPath = "//android.view.View[@content-desc=\\\"Укажите телефон\\n\" +\n" +
                "                \"На него отправим код подтверждения\\\"]/android.widget.EditText",
        elementName = "Ввод телефона"
    )

    val selectTypePhoneCode = ScreenConstructor(
        androidAccessibilityId = "Получить код",
        elementName = "Получить код"
    )

    val sPhoneCodeInput = ScreenConstructor(
        androidXPath = "//android.view.View[contains(@content-desc, 'Введите код из смс')]",
        elementName = "Код смс"
    )

    val onboardingData = OnboardingData(

    )

    val butEnter = ScreenConstructor (
        androidAccessibilityId = "Войти",
        elementName = "Кнопка Войти"
    )





}
