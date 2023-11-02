package good_test

import MainActivity
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit
import LocatorType
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import org.openqa.selenium.WebElement
import org.testng.annotations.*
import screens.Onboarding.selectAddress
import screens.TestFunctions.clickToElement


class TestSelectAddress : MainActivity() {

    @Test
    fun testSelectAddress() {
        println("Адрес выбран")
        checkAuthorizationUser(false)

        clickToElement(selectAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(5)
    }
}