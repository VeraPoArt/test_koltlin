
import GlobalVariables.androidDriver
import GlobalVariables.iosDriver
import GlobalVariables.platformType
import TestFunctions.chooseLocator
import TestFunctions.clickToElement
import org.openqa.selenium.WebElement
import io.appium.java_client.AppiumBy
import org.openqa.selenium.interactions.Pause
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.Sequence
import screens.Onboarding
import java.time.Duration.ofMillis

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

    fun chooseLocator (
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

        return findElement(finalLocator, finalLocatorType)
    }
}

    fun findElement(locator: String, locatorType: LocatorType) : WebElement{
        return when (locatorType) {
            LocatorType.ID -> {
                if (platformType == TypeOS.ANDROID) {
                    androidDriver.findElement(AppiumBy.id(locator))
                } else {
                    iosDriver.findElement(AppiumBy.id(locator))
                }
            }
            LocatorType.XPATH -> {
                if (platformType == TypeOS.ANDROID) {
                    androidDriver.findElement(AppiumBy.xpath(locator))
                } else {
                    iosDriver.findElement(AppiumBy.id(locator))
                }
            }
            LocatorType.ACCESSIBILITY_ID -> {
                if (platformType == TypeOS.ANDROID) {
                    androidDriver.findElement(AppiumBy.accessibilityId(locator))
                } else {
                    iosDriver.findElement(AppiumBy.accessibilityId(locator))
                }
            }
            LocatorType.CLASS_NAME -> {
                if (platformType == TypeOS.ANDROID) {
                    androidDriver.findElement(AppiumBy.className(locator))
                } else {
                    iosDriver.findElement(AppiumBy.className(locator))
                }
            }

            LocatorType.IOS_CLASS_CHAIN -> iosDriver.findElement(AppiumBy.iOSClassChain(locator))
            LocatorType.IOS_PREDICATE_STRING -> iosDriver.findElement(AppiumBy.iOSNsPredicateString(locator))
            LocatorType.DEFAULT -> TODO()
        }
    }

    fun checkAvailableElement(locatorAndroid: String,
                              locatorTypeAndroid: LocatorType,
                              locatorIOS: String,
                              locatorTypeIOS: LocatorType
    ) : Boolean {

        return chooseLocator (
            locatorAndroid, locatorTypeAndroid,
            locatorIOS, locatorTypeIOS
        ).isEnabled
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

        if (platformType == TypeOS.IOS) {
            iosDriver.perform(listOf(sequence))
        } else {
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

        if (platformType == TypeOS.IOS) {
            iosDriver.perform(listOf(sequence))
        } else {
            androidDriver.perform(listOf(sequence))
        }
    }

    fun navigateToMainScreen() {
        try {

            clickToElement(locatorAndroid = "//android.view.View[@content-desc=\"Русский\"]", locatorTypeAndroid = LocatorType.XPATH,
                locatorIOS: String, locatorTypeIOS: LocatorType);
            TimeUnit.SECONDS.sleep(10)

            clickToElement(locatorAndroid = Onboarding.selectRusButton.androidXpath, locatorTypeAndroid = LocatorType.XPATH,
                locatorIOS: String, locatorTypeIOS: LocatorType)
            TimeUnit.SECONDS.sleep(10)

            clickToElement(locatorAndroid = Onboarding.nextButton.androidAccessibilityId, locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS: String, locatorTypeIOS: LocatorType)
            TimeUnit.SECONDS.sleep(10)

            clickToElement(locatorAndroid = Onboarding.selectDeliveryButton.androidAccessibilityId, locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorIOS: String, locatorTypeIOS: LocatorType)
            TimeUnit.SECONDS.sleep(10)

        } catch (e: Exception) {
            println("Не удалось перейти на главный экран: ${e.message}")
            TimeUnit.SECONDS.sleep(10)

        }
    }

}
