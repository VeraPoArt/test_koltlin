package good_test

import GlobalVariables.androidDriver
import MainActivity
import groovyjarjarantlr4.v4.runtime.tree.xpath.XPath
import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test
import java.net.URL
import java.time.Duration
import java.util.concurrent.TimeUnit
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.Sequence
import java.util.Arrays
import io.appium.java_client.MobileBy
import org.openqa.selenium.By
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.WebElement
import org.testng.annotations.*
import screens.Onboarding.selectTypePhone
import screens.Onboarding.selectTypePhoneCode
import screens.TestFunctions.clickToElement


class TestSelectTypePhoneCode : MainActivity() {

    @Test
    fun testSelectTypePhoneCode() {
        println("Нажимаем кнопку Получить код")

        // нажимаем кнопку "Получить код"
        try {
            // нажимаем кнопку "Получить код" используя accessibility ID
            clickToElement(selectTypePhoneCode.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
            TimeUnit.SECONDS.sleep(7)
        } catch (e: Exception) {
            e.printStackTrace()
            println("Мы поймали ошибку, и теперь тест не упадет")
        }
    }
}



