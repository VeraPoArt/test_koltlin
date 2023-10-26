package test

import MainActivity
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class TestClassOne : MainActivity() {
}
@Test
fun testOne(){
    println("Тест запущен")
    TimeUnit.SECONDS.sleep(10)
}
