package screens

import io.appium.java_client.AppiumBy

object Onboarding {
    val selectRusButton = ScreenConstructor(
            androidXpath = "//android.view.View[@content-desc=\"Русский\"]",
            iosXpath = "",
            elementName = "Выбор русского языка на экране онбординга"
    )

    val nextButton = ScreenConstructor(
            androidAccessibilityId = "Далее",
            iosAccessibilityId = "",
            elementName = "Кнопка Далее на экране"
    )

    val selectDeliveryButton = ScreenConstructor(
            androidAccessibilityId = "Самовывоз",
            iosAccessibilityId = "",
            elementName = "Кнопка Самовывоз на экране"
    )

    val selectAddress = ScreenConstructor(
            androidAccessibilityId = "Shop 1\\n\" +\n" +
                    "//                \"Невский проспект 37",
            iosAccessibilityId = "",
            elementName = "Выбор адреса"
    )

    val selectPromo = ScreenConstructor(
            androidAccessibilityId = "Встречайте новинку: Пепперони с чили",
            iosAccessibilityId = "",
            elementName = "Проверка акции с пепперони"
    )

    val selectSnacks = ScreenConstructor(
        androidAccessibilityId = "Закуски",
        iosAccessibilityId = "",
        elementName = "Выбор закусок"
    )

    val selectTypePhone = ScreenConstructor(
        androidXpath = "//android.view.View[@content-desc=\"Укажите телефон\n" +
                "На него отправим код подтверждения\"]/android.widget.EditText",
        iosXpath = "",
        elementName = "Ввод телефона"
    )


    val selectTypePhoneCode = ScreenConstructor(
        androidAccessibilityId = "Получить код",
        iosAccessibilityId = "",
        elementName = "Получить код"
    )

    val enterCode = ScreenConstructor (
        androidXpath = "android.widget.EditText",
        iosXpath = "",
        elementName = "Поле ввода кода авторизации"
    )

    val sPhoneCodeInput = ScreenConstructor(
        androidXpath = "//android.view.View[contains(@content-desc, 'Введите код из смс')]",
        iosXpath = "",
        elementName = "Код смс"
    )

    val inputFieldScreen = ScreenConstructor(
        androidClassName = "android.widget.EditText",
        iosClassName = "",
        elementName = "Код смс"
    )



    val butEnter = ScreenConstructor (
        androidAccessibilityId = "Войти",
        elementName = "Кнопка Войти"
    )
    val enterPhone = ScreenConstructor (
        androidXpath = "//android.view.View[@content-desc=\"Укажите телефон\n" +
                "На него отправим код подтверждения\"]/android.widget.EditText",
        elementName = "Поле указание номера отправления кода для авторизации"
    )




}
