package good_test

import GlobalVariables.androidDriver
import MainActivity
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit
import LocatorType
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import screens.Onboarding.selectPromo
import screens.TestFunctions.clickToElement


class TestSelectPromo : MainActivity() {

    @Test
    fun testSelectPromo () {
        println("Акция")
        checkAuthorizationUser(false)

        clickToElement(selectPromo.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        androidDriver.navigate().back()
        TimeUnit.SECONDS.sleep(5)
    }
}