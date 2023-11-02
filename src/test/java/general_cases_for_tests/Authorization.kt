package general_cases_for_tests

import GlobalVariables.androidDriver
import GlobalVariables.iosDriver
import GlobalVariables.platformType
import LocatorType
import TestFunctions.clickToElement
import TestFunctions.sendText

import screens.MainScreen.butMenu
import screens.MainScreen.butProfile
import screens.Onboarding
import screens.Onboarding.enterCode
import screens.Onboarding.selectTypePhone
import screens.Onboarding.selectTypePhoneCode
import screens.TestFunctions.clickToElement
import screens.TestFunctions.sendText
import java.util.concurrent.TimeUnit

object Authorization {

    fun authorization(phoneNumber: String) {
        clickToElement(butProfile.androidXpath, LocatorType.XPATH)
        TimeUnit.SECONDS.sleep(7)

        clickToElement(Onboarding.butEnter.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(7)

        val phone = "9992092278"
        for (i in 0..9) {
            sendText(
                selectTypePhone.androidXpath,
                LocatorType.XPATH,
                selectTypePhone.iosClassChain,
                LocatorType.CLASS_NAME,
                phone[i].toString()
            )
            TimeUnit.SECONDS.sleep(5)
        }


        clickToElement(selectTypePhoneCode.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(10)

        val text = if (platformType == TypeOS.IOS) {
            iosDriver.pageSource
        } else {
            androidDriver.pageSource
        }

        sendText(
            enterCode.androidClassName,
            LocatorType.CLASS_NAME,
            enterCode.iosClassName,
            LocatorType.CLASS_NAME,
            text.substring(
                text.indexOf("Введите код из смс&#10;") + 23,
                text.indexOf("&#10;+7 (999) 209-22-78&")))
        TimeUnit.SECONDS.sleep(10)


        clickToElement(butMenu.androidXpath, LocatorType.XPATH)


    }
}