package good_test

import MainActivity
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit
import LocatorType
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import screens.Onboarding.selectDeliveryButton
import screens.TestFunctions.clickToElement

class TestDeliveryButton : MainActivity() {
    @Test
    fun testDeliveryButton1() {
        println("Тест запущен")
        checkAuthorizationUser(false)

        clickToElement(selectDeliveryButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(10)

    }
}
