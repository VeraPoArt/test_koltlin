package tests

import Delivery_adress.Address
import Delivery_adress.butAddress
import Delivery_adress.butAddressDelete
import Delivery_adress.butAddressSave
import Delivery_adress.butNoAllow
import Delivery_adress.inputAddress
import Delivery_adress.screenAddress
import LocatorType
import MainActivity
import TestFunctions.clickToElement
import TestFunctions.sendText
import general_cases_for_test.AddFullAddress.addFullAddress
import general_cases_for_test.Address.FullAddress
import general_cases_for_test.Address.deleteAddress
import general_cases_for_test.Address.swipeElementToDown
import general_cases_for_test.AuthorizationScenarios.checkAuthorizationUser
import general_cases_for_test.DeleteAddress.deleteAddress
import general_cases_for_test.FullAddress.FullAddress
import general_cases_for_test.SwipeElementUpToDown.swipeElementUpToDown
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import org.testng.annotations.Test
import screens.DeliveryScreen.buttonAddAddress
import screens.DeliveryScreen.buttonCross
import screens.DeliveryScreen.buttonSafe
import screens.DeliveryScreen.buttonUseDoNotAllow
import screens.DeliveryScreen.myAddress
import screens.DeliveryScreen.screenMyAddress
import screens.DeliveryScreen.sendAddress
import screens.MainScreen.butMenu
import screens.MainScreen.butProfile
import screens.MainScreen.buttonMenu
import screens.MainScreen.buttonProfile
import screens.ProfileScreen.buttonMyAddress
import screens.TestFunctions.clickToElement
import screens.TestFunctions.sendText
import java.util.concurrent.TimeUnit

class TestDeliveryAddress : MainActivity(){

    @Test
    fun testAddress0ne() {
        checkAuthorizationUser(true)

        clickToElement(butProfile.androidXPath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(7)

        clickToElement(butAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(11)

        try {
            while (true) {deleteAddress() }
        } catch (_: Exception){ }

        clickToElement(butAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(13)

        try {
            clickToElement(butNoAllow.androidXPath, LocatorType.XPATH)
            TimeUnit.SECONDS.sleep(10)
        } catch (_: Exception){ }

        clickToElement(butAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(10)

        clickToElement(inputAddress.androidClassName, LocatorType.CLASS_NAME)
        TimeUnit.SECONDS.sleep(10)

        clickToElement(butAddressDelete.androidXPath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(7)

        sendText(inputAddress.androidClassName, LocatorType.CLASS_NAME, Address.androidAccessibilityId)
        TimeUnit.SECONDS.sleep(8)

        clickToElement(Address.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(9)

        FullAddress()

        clickToElement(butAddressSave.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(10)

        try {
            while (true) {deleteAddress() }
        } catch (_: Exception){ }

        swipeElementToDown(screenAddress.androidXPath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(11)

        clickToElement(butMenu.androidXPath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(12)
    }
}
