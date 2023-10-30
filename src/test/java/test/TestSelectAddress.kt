package test

import MainActivity
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit
import LocatorType
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