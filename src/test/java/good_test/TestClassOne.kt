package good_test

import MainActivity
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit
import LocatorType
import TestFunctions.clickToElement
import screens.Onboarding.nextButton
import screens.Onboarding.selectDeliveryButton
import screens.Onboarding.selectRusButton
import screens.TestFunctions.clickToElement

class TestClassOne : MainActivity() {

    @Test
    fun testClassOne() {
        println("Тест запущен")

        clickToElement(selectRusButton.androidXPath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(5)

        clickToElement(nextButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(5)

    }
}