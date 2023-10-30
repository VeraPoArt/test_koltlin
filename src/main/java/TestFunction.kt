package screens
import GlobalVariables.androidDriver
import org.openqa.selenium.WebElement
import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.interactions.Pause
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.Sequence
import screens.OnboardingData
import java.time.Duration.ofMillis
import kotlin.time.Duration
import GlobalVariable.androidDriver
import LocatorType
import TestFunctions.clickToElement
import TestFunctions.sendText
import screens.AuthorizationScreen.buttonGetCode
import screens.AuthorizationScreen.enterCode
import screens.AuthorizationScreen.enterPhone
import screens.MainScreen
import screens.MainScreen.butProfile
import screens.Onboarding.butEnter
import screens.Onboarding.sPhoneCodeInput
import screens.Onboarding.selectTypePhone
import screens.Onboarding.selectTypePhoneCode
import screens.ProfileScreen.buttonEnter
import screens.TestFunctions.clickToElement
import screens.TestFunctions.sendText
import test.TestSPhoneCodeInput
import java.util.concurrent.TimeUnit

object TestFunctions {

    fun clickToElement (locator: String, locatorType: LocatorType) {
        val element = findElement(locator, locatorType)
        element.click()
    }

    fun sendText(locator: String, locatorType: LocatorType, text: String) {
        val element = findElement(locator, locatorType)
        element.sendKeys(text)
    }

    fun clearField(locator: String,locatorType: LocatorType) {
        val element = findElement(locator, locatorType)
        element.clear()
    }



    private fun findElement(locator: String, locatorType: LocatorType) : WebElement {
        return when (locatorType) {
            LocatorType.ID -> androidDriver.findElement(AppiumBy.id(locator))
            LocatorType.XPATH ->  androidDriver.findElement(AppiumBy.xpath(locator))
            LocatorType.ACCESSIBILITY_ID -> androidDriver.findElement(AppiumBy.accessibilityId(locator))
            LocatorType.CLASS_NAME -> androidDriver.findElement(AppiumBy.className(locator))
        }
    }

    fun checkAvailableElement(locator: String,locatorType: LocatorType) : Boolean {
        val element = findElement(locator, locatorType)
        return element.isEnabled
    }

    fun inputCode(data: OnboardingData) {
        data.inputField.sendKeys(data.code)
    }


    fun tapByCoordinates(x: Int, y: Int) {
        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")

        val move = finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y)
        val tap = finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())
        val release = finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())

        val sequence = Sequence(finger, 0)
        sequence.addAction(move)  // Move first
        sequence.addAction(tap)   // Then press down
        sequence.addAction(release) // Then release

        androidDriver.perform(listOf.asList(sequence))
    }

    fun swipeOnScreen(startX: Int, startY: Int, moveX: Int, moveY: Int) {
        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val sequence = Sequence(finger, 1)

        sequence.addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
        sequence.addAction(Pause(finger, ofMillis(600)))
        sequence.addAction(finger.createPointerMove(ofMillis(1000), PointerInput.Origin.viewport(), moveX, moveY))
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))

        androidDriver.perform(listOf.asList(sequence))
    }

    fun navigateToMainScreen() {
        try {
            clickToElement(locator = "//android.view.View[@content-desc=\"Русский\"]", locatorType = LocatorType.XPATH)
            TimeUnit.SECONDS.sleep(10)

            clickToElement(Onboarding.selectRusButton.androidXPath, LocatorType.XPATH)
            TimeUnit.SECONDS.sleep(10)

            clickToElement(Onboarding.nextButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
            TimeUnit.SECONDS.sleep(10)

            clickToElement(Onboarding.selectDeliveryButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
            TimeUnit.SECONDS.sleep(10)

        } catch (e: Exception) {
            println("Не удалось перейти на главный экран: ${e.message}")
            TimeUnit.SECONDS.sleep(10)

        }
    }

}
