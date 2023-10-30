package test

import GlobalVariables.androidDriver
import MainActivity
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit
import LocatorType
import java.util.concurrent.TimeUnit
import org.openqa.selenium.WebElement
import org.testng.annotations.*
import screens.Onboarding
import screens.Onboarding.*
import screens.Onboarding.selectPromo
import screens.TestFunctions.clickToElement


class TestSelectPromo : MainActivity() {

    @Test
    fun testSelectPromo () {
        println("Акция")
        clickToElement(selectPromo.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        androidDriver.navigate().back()
        TimeUnit.SECONDS.sleep(5)
    }
}