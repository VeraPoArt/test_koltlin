package test

import MainActivity
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit
import LocatorType
import TestFunctions.clickToElement
import java.util.concurrent.TimeUnit
import org.openqa.selenium.WebElement
import org.testng.annotations.*
import screens.Onboarding.*
import screens.Onboarding.nextButton
import screens.Onboarding.selectAddress
import screens.Onboarding.selectDeliveryButton
import screens.Onboarding.selectRusButton
import screens.TestFunctions.clickToElement

class TestClassOne : MainActivity() {

    @Test
    fun testOne() {
        println("Тест запущен")
        clickToElement(locator = "//android.view.View[@content-desc=\"Русский\"]", locatorType = LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(10)

        clickToElement(selectRusButton.androidXPath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(5)

        clickToElement(nextButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(5)

    }
}