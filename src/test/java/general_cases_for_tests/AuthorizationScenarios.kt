package general_cases_for_tests

import GlobalVariables.androidDriver
import LocatorType
import screens.MainScreen.butExit
import screens.MainScreen.butMenu
import screens.MainScreen.butProfile
import screens.Onboarding.butEnter
import screens.Onboarding.enterCode
import screens.Onboarding.enterPhone
import screens.Profile.phoneNumberElement
import screens.TestFunctions.checkAvailableElement
import screens.TestFunctions.clickToElement
import screens.TestFunctions.sendText
import java.util.concurrent.TimeUnit

object AuthorizationScenarios {

    fun checkAuthorizationUser(needAuthorizationUser: Boolean) {

        var userIsAuthorization: Boolean
        try {

            clickToElement(
                butProfile.androidXPath,
                LocatorType.XPATH)
            TimeUnit.SECONDS.sleep(7)
            userIsAuthorization = checkAvailableElement(phoneNumberElement.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)



            userIsAuthorization = checkAvailableElement("locator", LocatorType.XPATH)
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            userIsAuthorization = false

        }
        when {
            needAuthorizationUser && userIsAuthorization -> {
                clickToElement(butMenu.androidXPath,
                    LocatorType.XPATH)


            }
            needAuthorizationUser && !userIsAuthorization -> {

                clickToElement(
                    butEnter.androidAccessibilityId,
                    LocatorType.ACCESSIBILITY_ID,

                )
                TimeUnit.SECONDS.sleep(5)

                val phone = "9992092278"
                for (i in 0..9) {
                    sendText(
                        enterPhone.androidXPath,
                        LocatorType.XPATH,
                        enterPhone.iosClassName,
                        LocatorType.CLASS_NAME,
                        phone[i].toString()
                    )
                    TimeUnit.SECONDS.sleep(5)
                }
                val text = if (platformType == TypeOS.IOS) {
                    iosDriver.pageSource
                } else {
                    androidDriver.pageSource
                }

                sendText(
                    enterCode.androidClassName,
                    LocatorType.CLASS_NAME,
                    text.substring(
                        text.indexOf("Введите код из смс&#10;") + 23,
                        text.indexOf("&#10;+7 (999) 209-22-78&")))
                TimeUnit.SECONDS.sleep(10)

                clickToElement(
                    butMenu.androidXPath,
                    LocatorType.XPATH

                TimeUnit.SECONDS.sleep(5)
            }


            !needAuthorizationUser && userIsAuthorization -> {
                clickToElement(
                    butExit.androidAccessibilityId,
                    LocatorType.ACCESSIBILITY_ID,
                    butExit.iosAccessibilityId
                )
                TimeUnit.SECONDS.sleep(5)

                clickToElement(
                    butMenu.androidXPath,
                    LocatorType.XPATH,
                    butMenu.iosClassChain
                )
                TimeUnit.SECONDS.sleep(5)
            }



            !needAuthorizationUser && !userIsAuthorization -> {
                clickToElement(
                    butMenu.androidXPath,
                    LocatorType.XPATH,
                    butMenu.iosClassChain
                )
                TimeUnit.SECONDS.sleep(5)
            }
        }

    }
}