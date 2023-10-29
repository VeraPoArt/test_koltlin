package general_cases_for_tests

import GlobalVariable.androidDriver
import LocatorType
import TestFunctions.checkAvailableElement
import TestFunctions.clickToElement
import TestFunctions.sendText
import screens.AuthorizationScreen
import screens.MainScreen.butExit
import screens.MainScreen.butMenu
import screens.MainScreen.butProfile
import screens.MainScreen.buttonMenu
import screens.MainScreen.buttonProfile
import screens.Onboarding
import screens.Onboarding.selectTypePhone
import screens.Onboarding.selectTypePhoneCode
import screens.Profile.authPerson
import screens.Profile.phoneNumberElement
import screens.ProfileScreen.authorizationPerson
import screens.ProfileScreen.buttonEnter
import screens.ProfileScreen.buttonExit
import screens.TestFunctions
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
                sendText(
                    selectTypePhone.androidXPath,
                    LocatorType.XPATH,
                    "9992092278")
                TimeUnit.SECONDS.sleep(7)

                clickToElement(
                    selectTypePhoneCode.androidAccessibilityId,
                    LocatorType.ACCESSIBILITY_ID)
                TimeUnit.SECONDS.sleep(7)

                clickToElement(Onboarding.sPhoneCodeInput.androidXPath, LocatorType.XPATH)
                TimeUnit.SECONDS.sleep(5)
                println(Onboarding.onboardingData.fullText)
                println(Onboarding.onboardingData.regex)
                println(Onboarding.onboardingData.matchResult)
                println(Onboarding.onboardingData.code)
                println(Onboarding.onboardingData.inputField)
                TestFunctions.inputCode(Onboarding.onboardingData)


            }
            !needAuthorizationUser && userIsAuthorization -> {
                clickToElement(
                    butExit.androidAccessibilityId,
                    LocatorType.ACCESSIBILITY_ID)
                clickToElement(
                    butMenu.androidXPath,
                    LocatorType.XPATH)
            }
            !needAuthorizationUser && !userIsAuthorization -> {
                clickToElement(
                    butMenu.androidXPath,
                    LocatorType.XPATH)
            }
        }

    }
}