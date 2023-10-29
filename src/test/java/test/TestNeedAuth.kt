package tests

import MainActivity
import general_cases_for_test.Authorization.authorization
import general_cases_for_tests.AuthorizationScenarios.checkAuthorizationUser
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class TestNeededAuthorization : MainActivity() {

    @Test
    fun test1(){
        println("Авторизация не нужна и ее нет")
        checkAuthorizationUser(false)
        TimeUnit.SECONDS.sleep(5)
    }

    @Test
    fun test2(){
        println("Авторизация нужна, но ее нет")
        checkAuthorizationUser(true)
        TimeUnit.SECONDS.sleep(5)
    }

    @Test
    fun test3(){
        println("Авторизация не нужна, но она есть")
        checkAuthorizationUser(false)
        TimeUnit.SECONDS.sleep(5)
    }

    @Test
    fun test4(){
        println("Авторизация нужна и она есть")
        authorization("9879915981")
        checkAuthorizationUser(true)
        TimeUnit.SECONDS.sleep(5)
    }
}