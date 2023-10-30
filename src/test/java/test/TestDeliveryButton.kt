package test

import MainActivity
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit
import LocatorType
import TestFunctions.clickToElement
import screens.Onboarding
import java.util.concurrent.TimeUnit
import org.openqa.selenium.WebElement
import org.testng.annotations.*
import screens.Onboarding.*
import screens.Onboarding.selectAddress
import screens.Onboarding.selectDeliveryButton
import screens.Onboarding.selectRusButton

class TestDeliveryButton : MainActivity() {
    @Test
    fun testOne(){
        println("Тест запущен")
        clickToElement(selectDeliveryButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(10)

    }
}
