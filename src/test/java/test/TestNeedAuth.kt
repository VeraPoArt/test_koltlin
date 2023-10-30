package tests

import MainActivity
import general_cases_for_test.Authorization.authorization
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class TestNeedAuth : MainActivity() {

    @Test
    fun testOne(){
        println("Авторизация не нужна и ее нет")
        checkAuthorizationUser(false)
        TimeUnit.SECONDS.sleep(5)
    }

    @Test
    fun testTwo(){
        println("Авторизация нужна, но ее нет")
        checkAuthorizationUser(true)
        TimeUnit.SECONDS.sleep(5)
    }

    @Test
    fun testThree(){
        println("Авторизация не нужна, но она есть")
        checkAuthorizationUser(false)
        TimeUnit.SECONDS.sleep(5)
    }

    @Test
    fun testFour(){
        println("Авторизация нужна и она есть")
        authorization("9879915981")
        checkAuthorizationUser(true)
        TimeUnit.SECONDS.sleep(5)
    }
}