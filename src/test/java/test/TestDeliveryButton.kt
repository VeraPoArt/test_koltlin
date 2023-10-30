package test

import MainActivity
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit
import LocatorType
import TestFunctions.clickToElement
import java.util.concurrent.TimeUnit
import org.testng.annotations.*
import screens.Onboarding.*
import screens.Onboarding.selectDeliveryButton
import screens.TestFunctions.clickToElement

class TestDeliveryButton : MainActivity() {
    @Test
    fun testDeliveryButton1() {
        println("Тест запущен")
        clickToElement(selectDeliveryButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(10)

    }
}
