package test

import GlobalVariables.androidDriver
import MainActivity
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit
import LocatorType
import TestFunctions.clickToElement
import clickToElement
import general_cases_for_test.AuthorizationScenarios.checkAuthorizationUser
import org.testng.annotations.Test
import screens.MainScreen.pumpkinSoup
import screens.MainScreen.tabSoup
import java.util.concurrent.TimeUnit
import org.openqa.selenium.WebElement
import org.testng.annotations.*
import screens.Onboarding
import screens.Onboarding.*
import screens.Onboarding.selectPromo
import screens.TestFunctions.clickToElement


class TestSelectPromo : MainActivity() {

    @Test
    fun testOne() {
        println("Акция")
        clickToElement(selectPromo.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        androidDriver.navigate().back()
        TimeUnit.SECONDS.sleep(5)
    }
}