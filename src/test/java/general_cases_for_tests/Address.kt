package general_cases_for_test

import Delivery_adress.deleteAddAddress
import Delivery_adress.fullAddress
import Delivery_adress.inputCodeParad
import Delivery_adress.inputComment
import Delivery_adress.inputFloor
import Delivery_adress.inputKv
import Delivery_adress.inputParadnaya
import LocatorType
import screens.TestFunctions.clickToElement
import screens.TestFunctions.sendText
import screens.TestFunctions.swipeOnScreen
import screens.TestFunctions.tapByCoordinates
import java.util.concurrent.TimeUnit

object Address {

    fun FullAddress(){
        tapByCoordinates(500, 1300)TimeUnit.SECONDS.sleep(10)

        clickToElement(inputKv.androidXPath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(5)
        sendText(inputKv.androidXPath, LocatorType.XPATH, "13")
        TimeUnit.SECONDS.sleep(5)

        clickToElement(inputCodeParad.androidXPath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(5)
        sendText(inputCodeParad.androidXPath, LocatorType.XPATH, "123")
        TimeUnit.SECONDS.sleep(5)

        clickToElement(inputParadnaya.androidXPath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(5)
        sendText(inputParadnaya.androidXPath, LocatorType.XPATH, "2")
        TimeUnit.SECONDS.sleep(5)

        clickToElement(inputComment.androidXPath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(5)
        sendText(inputComment.androidXPath, LocatorType.XPATH, "Спасибо за доставку")
        TimeUnit.SECONDS.sleep(5)

        clickToElement(inputFloor.androidXPath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(5)
        sendText(inputFloor.androidXPath, LocatorType.XPATH, "1")
        TimeUnit.SECONDS.sleep(5)
    }

    fun deleteAddress (){

        swipeElementToLeft(fullAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(5)

        val element = findElement(deleteAddAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)

        tapByCoordinates(element.size.width - 200, element.size.height + 200)
        TimeUnit.SECONDS.sleep(5)
    }

    fun swipeElementToLeft (locator : String, locatorType: LocatorType) {
        val element = findElement(locator, locatorType)
        val point = element.location
        val size = element.size

        swipeOnScreen(
            point.x + size.width/2,
            point.y + size.height/2,
            point.x,
            point.y + size.height/2
        )
    }

    fun swipeElementToDown (locator : String, locatorType: LocatorType) {
        val element = findElement(locator, locatorType)
        val point = element.location
        val size = element.size

        swipeOnScreen(
            point.x + size.width/2,
            point.y,
            point.x + size.width/2,
            point.y + size.height
        )
    }

}