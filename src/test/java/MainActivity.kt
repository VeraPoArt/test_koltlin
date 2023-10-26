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
import org.openqa.selenium.By
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.WebElement
import org.testng.annotations.AfterClass
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import screens.Onboarding.selectRusButton
import screens.Onboarding.nextButton
import screens.Onboarding.selectDeliveryButton
import screens.Onboarding.selectAddress


open class MainActivity {
    @BeforeSuite
    fun installDriver(){
        val capabilities = DesiredCapabilities()
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.0")
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel")
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/heads/apps/app-profile.apk")
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2")
        val url = URL("http://127.0.0.1:4723/")
        androidDriver = AndroidDriver(url, capabilities)
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))


// clickToElement позволяет оптимизировать код - поправить свои значения
        clickToElement(locator = "//android.view.View[@content-desc=\"Русский\"]", locatorType = LocatorType.XPATH)
//        val element1 = androidDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Русский\"]"))
        //       element1.click()
        TimeUnit.SECONDS.sleep(5)

        clickToElement(selectRusButton.androidXPath, LocatorType.XPATH)

//        val element2 = androidDriver.findElement(AppiumBy.accessibilityId("Далее"))
//        element2.click()

        TimeUnit.SECONDS.sleep(5)


        clickToElement(selectDeliveryButton.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)

//        val element3 = androidDriver.findElement(AppiumBy.accessibilityId("Самовывоз"))
//        element3.click()

        TimeUnit.SECONDS.sleep(10)

        // Проверяем выбор адреса


//        val element4 = androidDriver.findElement(AppiumBy.accessibilityId("Shop 1\n" +
//                "Невский проспект 37"))
//        element4.click()
//      selectAddress
        clickToElement(selectAddress.androidAccessibilityId, LocatorType.ACCESSIBILITY_ID)
        TimeUnit.SECONDS.sleep(5)

        // Проверяем акцию
        val element5 = androidDriver.findElement(AppiumBy.accessibilityId("Встречайте новинку: Пепперони с чили"))
        element5.click()
        TimeUnit.SECONDS.sleep(5)


        // Возвращаемся на предыдущую страницу
        androidDriver.navigate().back()
        TimeUnit.SECONDS.sleep(5)


        // Выбираем закуски
        val element6 = androidDriver.findElement(AppiumBy.accessibilityId("Закуски"))
        element6.click()
        TimeUnit.SECONDS.sleep(10)


        fun tapByCoordinates(driver: AndroidDriver, x: Int, y: Int) {
            val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")

            val move = finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y)
            val tap = finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())
            val release = finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())

            val sequence = Sequence(finger, 0)
            sequence.addAction(move)  // Move first
            sequence.addAction(tap)   // Then press down
            sequence.addAction(release) // Then release

            driver.perform(Arrays.asList(sequence))
        }

        // кладем выбранную позицию
        tapByCoordinates(androidDriver, 153, 1038)
        TimeUnit.SECONDS.sleep(5)


        // нажимаем на кнопку с ценой
        tapByCoordinates(androidDriver, 603, 1991)
        TimeUnit.SECONDS.sleep(5)


        // нажимаем на кнопку с корзиной
        val x1 = 893
        val y1 = 1918
        val x2 = 1025
        val y2 = 2050
        val x_center = (x1 + x2) / 2
        val y_center = (y1 + y2) / 2
        tapByCoordinates(androidDriver, x_center, y_center)
        TimeUnit.SECONDS.sleep(5)


        // нажимаем на кнопку/не кнопку
        tapByCoordinates(androidDriver, 553, 2000)
        TimeUnit.SECONDS.sleep(5)



        // вводим номер телефона
        val element7 = androidDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Укажите телефон\n" +
                "На него отправим код подтверждения\"]/android.widget.EditText"))
        element7.sendKeys("9992092278")
        TimeUnit.SECONDS.sleep(5)



        // нажимаем кнопку "Получить код"
        val element8 = androidDriver.findElement(AppiumBy.accessibilityId("Получить код"))
        element8.click()
        TimeUnit.SECONDS.sleep(7)


        try {
            // Находим элемент
            val element11: WebElement = androidDriver.findElement(AppiumBy.id("Получить код"))
            element11.click()
            TimeUnit.SECONDS.sleep(7)

        } catch (e: org.openqa.selenium.NoSuchElementException) {
            e.printStackTrace()
            println("Мы поймали ошибку, и теперь тест не упадет")
        }

        // извлекаем код смс
        // Шаг 1: Находим элемент на странице по части XPath
        val element = androidDriver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Введите код из смс')]"))

        // Шаг 2: Извлекаем код из значения атрибута элемента
        val fullText = element.getAttribute("content-desc") // Получаем полное значение content-desc
        val regex = """\b\d{4}\b""".toRegex() // Регулярное выражение для поиска четырехзначного числа
        val matchResult = regex.find(fullText)
        val code = matchResult?.value ?: throw Exception("Код не найден!")

        // Шаг 3: Вводим код в поле ввода
        // Находим элемент по его имени класса
        val inputField = androidDriver.findElement(AppiumBy.className("android.widget.EditText"))

        // Вводим код в найденное поле ввода
        inputField.sendKeys(code)


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