package general_cases_for_test

import GlobalVariable.androidDriver
import LocatorType
import TestFunctions.clickToElement
import TestFunctions.sendText
import screens.AuthorizationScreen.buttonGetCode
import screens.AuthorizationScreen.enterCode
import screens.AuthorizationScreen.enterPhone
import screens.MainScreen
import screens.MainScreen.butMenu
import screens.MainScreen.butProfile
import screens.MainScreen.buttonProfile
import screens.Onboarding
import screens.Onboarding.butEnter
import screens.Onboarding.sPhoneCodeInput
import screens.Onboarding.selectTypePhone
import screens.Onboarding.selectTypePhoneCode
import screens.Onboarding.butEnter
import screens.TestFunctions.clickToElement
import screens.TestFunctions.sendText
import java.util.concurrent.TimeUnit

object Authorization {

    fun authorization(phoneNumber: String) {
        clickToElement(butProfile.androidXPath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(7)

        clickToElement(Onboarding.butEnter.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(7)

        sendText(selectTypePhone.androidXPath, LocatorType.XPATH, phoneNumber)
        TimeUnit.SECONDS.sleep(7)

        clickToElement(selectTypePhoneCode.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(10)

        clickToElement(sPhoneCodeInput.androidXPath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(10)

        clickToElement(butMenu.androidXPath, LocatorType.XPATH)

        // SessionState и данные

    }
}