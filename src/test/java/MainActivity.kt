import GlobalVariables.androidDriver
import TestFunctions.clickToElement
import groovyjarjarantlr4.v4.runtime.tree.xpath.XPath
import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test
import java.net.URL
import java.time.Duration
import java.util.concurrent.TimeUnit
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.Sequence
import java.util.Arrays
import io.appium.java_client.MobileBy
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType.NO_RESET
import org.openqa.selenium.By
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.WebElement
import org.testng.annotations.*
import screens.Onboarding.*
import screens.Onboarding.selectAddress
import screens.Onboarding.selectDeliveryButton
import screens.Onboarding.selectPromo
import screens.Onboarding.selectRusButton
import screens.TestFunctions.navigateToMainScreen


open class MainActivity {
    @BeforeSuite
    fun installDriver(){
        val capabilities = DesiredCapabilities()
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.0")
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel")
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/heads/apps/app-profile.apk")
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "starter.school.client")
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "starter.school.client.MainActivity")
        capabilities.setCapability(NO_RESET, true)


        val url = URL("http://127.0.0.1:4723/")
        androidDriver = AndroidDriver(url, capabilities)
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))



        navigateToMainScreen()



    }

    @AfterSuite
    fun quitDriver(){
        androidDriver.quit()
    }

    @Test
    fun testOne(){
        println("Тест запущен")
        TimeUnit.SECONDS.sleep(10)
    }

    @BeforeClass
    fun beforeClass(){

    }

    @AfterClass
    fun afterClass(){

    }

    @BeforeMethod
    fun launceApp(){
        androidDriver.activateApp(BUNDLE_ID)
        TimeUnit.SECONDS.sleep(10)
    }
    @AfterMethod
    fun closeApp(){
        androidDriver.terminateApp(BUNDLE_ID)
    }

    companion object {
        const val BUNDLE_ID = "starter.school.client"
    }

}