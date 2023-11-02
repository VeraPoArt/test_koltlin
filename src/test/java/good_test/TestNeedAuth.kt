package good_test

import MainActivity
import general_cases_for_test.Authorization.authorization
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class TestNeedAuth : MainActivity() {

    @Test
    fun testsOne(){
        println("Авторизация не нужна и ее нет")
        checkAuthorizationUser(false)
        TimeUnit.SECONDS.sleep(5)
    }

    @Test
    fun testsTwo(){
        println("Авторизация нужна, но ее нет")
        checkAuthorizationUser(true)
        TimeUnit.SECONDS.sleep(5)
    }

    @Test
    fun testsThree(){
        println("Авторизация не нужна, но она есть")
        checkAuthorizationUser(false)
        TimeUnit.SECONDS.sleep(5)
    }

    @Test
    fun testsFour(){
        println("Авторизация нужна и она есть")
        authorization("9879915981")
        checkAuthorizationUser(true)
        TimeUnit.SECONDS.sleep(5)
    }
}