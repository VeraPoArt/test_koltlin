package screens
import GlobalVariables.androidDriver
import GlobalVariables.platformType
import org.openqa.selenium.WebElement
import io.appium.java_client.AppiumBy
import org.openqa.selenium.interactions.Pause
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.Sequence
import java.time.Duration.ofMillis
import LocatorType

import java.util.concurrent.TimeUnit

object TestFunctions {

    fun clickToElement (
        locatorAndroid: String, locatorTypeAndroid: LocatorType,
        locatorIOS: String, locatorTypeIOS: LocatorType
    ) {
        val finalLocator: String
        val finalLocatorType: LocatorType
        if (platformType == TypeOS.ANDROID) {
            finalLocator = locatorAndroid
            finalLocatorType = locatorTypeAndroid
        } else {
            finalLocator = locatorIOS
            finalLocatorType = locatorTypeIOS
        }

        val element = findElement(finalLocator, finalLocatorType)
        element.click()
    }

    fun sendText(
        locatorAndroid: String, locatorTypeAndroid: LocatorType,
        locatorIOS: String, locatorTypeIOS: LocatorType, text: String)
    {
        val finalLocator: String
        val finalLocatorType: LocatorType
        if (platformType == TypeOS.ANDROID) {
            finalLocator = locatorAndroid
            finalLocatorType = locatorTypeAndroid
        } else {
            finalLocator = locatorIOS
            finalLocatorType = locatorTypeIOS
        }
        val element = findElement(finalLocator, finalLocatorType)
        element.sendKeys(text)


    }
    fun checkAvailableElement(
        locatorAndroid: String,
        locatorTypeAndroid: LocatorType,
        locatorIOS: String,
        locatorTypeIOS: LocatorType
    ) : Boolean {

        return chooseLocator (
            locatorAndroid, locatorTypeAndroid,
            locatorIOS, locatorTypeIOS
        ).isEnabled
    }
    fun clearField(
        locatorAndroid: String, locatorTypeAndroid: LocatorType,
        locatorIOS: String, locatorTypeIOS: LocatorType)
    {
        val finalLocator: String
        val finalLocatorType: LocatorType
        if (platformType == TypeOS.ANDROID) {
            finalLocator = locatorAndroid
            finalLocatorType = locatorTypeAndroid
        } else {
            finalLocator = locatorIOS
            finalLocatorType = locatorTypeIOS
        }
        val element = findElement(finalLocator, finalLocatorType)
        element.clear()
    }

    private fun chooseLocator (
        locatorAndroid: String,
        locatorTypeAndroid: LocatorType,
        locatorIOS: String,
        locatorTypeIOS: LocatorType
    ) : WebElement {

        val finalLocator: String
        val finalLocatorType: LocatorType
        if (platformType == TypeOS.ANDROID) {
            finalLocator = locatorAndroid
            finalLocatorType = locatorTypeAndroid
        } else {
            finalLocator = locatorIOS
            finalLocatorType = locatorTypeIOS
        }
    }

    fun findElement(locator: String, locatorType: LocatorType) : WebElement {
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

    fun inputCode(data: OnboardingData, code: String) {
        val inputFieldScreen = ScreenConstructor(
            androidClassName = "android.widget.EditText",
            elementName = "Код смс"
        )

        findElement(inputFieldScreen.androidClassName, LocatorType.CLASS_NAME)
        sendText(inputFieldScreen.androidClassName, LocatorType.CLASS_NAME)
        clickToElement(Onboarding.sPhoneCodeInput.androidXPath, LocatorType.XPATH)
    }



    fun tapByCoordinates(x: Int, y: Int) {
        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")

        val move = finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), x, y)
        val tap = finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())
        val release = finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())

        val sequence = Sequence(finger, 0)
        sequence.addAction(move)  // Move first
        sequence.addAction(tap)   // Then press down
        sequence.addAction(release) // Then release

        androidDriver.perform(listOf(sequence))
    }

    fun swipeOnScreen(startX: Int, startY: Int, moveX: Int, moveY: Int) {
        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val sequence = Sequence(finger, 1)

        sequence.addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()))
        sequence.addAction(Pause(finger, ofMillis(600)))
        sequence.addAction(finger.createPointerMove(ofMillis(1000), PointerInput.Origin.viewport(), moveX, moveY))
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()))

        androidDriver.perform(listOf(sequence))
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
