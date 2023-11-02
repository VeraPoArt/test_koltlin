package screens

object MainScreen {

    val butProfile = ScreenConstructor(
        androidXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]",
        elementName = "Кнопка профиля"
    )

    val butMenu = ScreenConstructor (
        androidXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]",
        elementName = "Главное меню"
    )

    val butExit = ScreenConstructor (
        androidAccessibilityId = "Выйти",
        elementName = "Кнопка Выйти"    )
}