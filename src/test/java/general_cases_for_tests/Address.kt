package general_cases_for_tests

import Delivery_adress.deleteAddAddress
import Delivery_adress.fullAddress
import Delivery_adress.inputCodeParad
import Delivery_adress.inputComment
import Delivery_adress.inputFloor
import Delivery_adress.inputKv
import Delivery_adress.inputParadnaya
import LocatorType
import TestFunctions.clickToElement
import TestFunctions.sendText
import findElement

import tapByCoordinates
import java.util.concurrent.TimeUnit

object Address {

    fun FullAddress(){
        tapByCoordinates(500, 1300)
        TimeUnit.SECONDS.sleep(10)

        clickToElement(inputKv.androidXpath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(5)
        sendText(inputKv.androidXpath, LocatorType.XPATH, "13")
        TimeUnit.SECONDS.sleep(5)

        clickToElement(inputCodeParad.androidXpath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(5)
        sendText(inputCodeParad.androidXpath, LocatorType.XPATH, "123")
        TimeUnit.SECONDS.sleep(5)

        clickToElement(inputParadnaya.androidXpath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(5)
        sendText(inputParadnaya.androidXpath, LocatorType.XPATH, "2")
        TimeUnit.SECONDS.sleep(5)

        clickToElement(inputComment.androidXpath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(5)
        sendText(inputComment.androidXpath, LocatorType.XPATH, "Спасибо за доставку")
        TimeUnit.SECONDS.sleep(5)

        clickToElement(inputFloor.androidXpath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(5)
        sendText(inputFloor.androidXpath, LocatorType.XPATH, "1")
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

    swipeOnScreen(point.x + size.width/2, point.y + size.height/2, point.x, point.y + size.height/2)
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