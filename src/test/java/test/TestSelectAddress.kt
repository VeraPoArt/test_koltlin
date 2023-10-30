package test

import MainActivity
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit
import LocatorType
import TestFunctions.clickToElement
import general_cases_for_test.AuthorizationScenarios.checkAuthorizationUser
import org.testng.annotations.Test
import screens.MainScreen.pumpkinSoup
import screens.MainScreen.tabSoup
import java.util.concurrent.TimeUnit
import org.openqa.selenium.WebElement
import org.testng.annotations.*
import screens.Onboarding.*
import screens.Onboarding.selectAddress
import screens.TestFunctions.clickToElement


class TestSelectAddress : MainActivity() {

    @Test
    fun testOne() {
        println("Адрес выбран")
        clickToElement(selectAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(5)
    }
}