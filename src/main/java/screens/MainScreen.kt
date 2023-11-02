package screens

object MainScreen {

    val butProfile = ScreenConstructor(
        androidXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]",
        iosXpath = "",
        elementName = "Кнопка профиля"
    )

    val butMenu = ScreenConstructor (
        androidXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]",
        iosXpath = "",
        elementName = "Главное меню"
    )

    val butExit = ScreenConstructor (
        androidAccessibilityId = "Выйти",
        iosAccessibilityId = "",
        elementName = "Кнопка Выйти"    )
}