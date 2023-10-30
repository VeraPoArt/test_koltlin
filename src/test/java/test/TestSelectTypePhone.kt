package test

import GlobalVariables.androidDriver
import MainActivity
import TestFunctions.clickToElement
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
import screens.TestFunctions.clickToElement


class TestSelectTypePhone : MainActivity() {

    @Test
    fun testOne() {
        println("Вводим номер телефона")

        // вводим номер телефона
        clickToElement(selectTypePhone.androidXPath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(5)
        selectTypePhone.sendKeys("9992092278")

    }
}