import LocatorType
import screens.ScreenConstructor

import java.util.concurrent.TimeUnit

object Delivery_adress {


        val butAddress = ScreenConstructor (
                androidAccessibilityId = "Добавить новый адрес",
                elementName = "Добавить адрес")

        val inputAddress = ScreenConstructor (
                androidClassName = "android.widget.EditText",
                elementName = "Инпут адрес")

        val inputKv = ScreenConstructor (
                androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]",
                elementName = "Инпут квартира")

        val inputParadnaya = ScreenConstructor (
                androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]",
                elementName = "Инпут подьезд"
        )

        val inputCodeParad = ScreenConstructor (
                androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]",
                elementName = "Инпут домофон"
        )

        val inputFloor = ScreenConstructor (
                androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[4]",
                elementName = "Инпут этаж"
        )

        val inputComment = ScreenConstructor (
                androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[5]",
                elementName = "Инпут коментарий"
        )

        val butAddressSave = ScreenConstructor (
                androidAccessibilityId = "Сохранить",
                elementName = "Кнопка сохранить из адреса"
        )

        val butNoAllow = ScreenConstructor (
                androidAccessibilityId = "com.android.permissioncontroller:id/permission_deny_button",
                androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[3]",
                elementName = "Кнопка Don't allow"
        )

        val butAddressDelete = ScreenConstructor (
                androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.widget.EditText/android.widget.ImageView",
                elementName = "Удаление адреса"
        )

        val Address = ScreenConstructor (
                androidAccessibilityId = "Озерный переулок, 3, Санкт-Петербург",
                elementName = "Выбор адреса"
        )

        val fullAddress = ScreenConstructor (
                androidAccessibilityId = "Озерный переулок, 3\n" +
        "кв 13, 1 подъезд, 2 этаж. Домофон: 123. Спасибо за доставку",
                elementName = "Полный адрес"
        )

        val screenAddress = ScreenConstructor (
                androidXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View",
                elementName = "все адреса"
        )


        val deleteAddAddress = ScreenConstructor (
                androidAccessibilityId = "Удалить",
                elementName = "Кнопка удалить при свайпе адреса на удаление"
        )



}





