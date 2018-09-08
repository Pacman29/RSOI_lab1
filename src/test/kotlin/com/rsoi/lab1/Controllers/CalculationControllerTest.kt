package com.rsoi.lab1.Controllers

import com.rsoi.lab1.Services.ActionsLogService
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculationControllerTest {

    @Autowired
    lateinit var actionsLogService : ActionsLogService

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun info() {
        val result = testRestTemplate.getForEntity("/calc",String::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body, "this is calculation controller")
    }

    @Test
    fun plus() {
        val result = testRestTemplate.getForEntity("/calc/plus",String::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body?.toDouble(), 0.0)
    }

    @Test
    fun plusSomeValues() {
        val result = testRestTemplate.getForEntity("/calc/plus?a=10&b=5",String::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body?.toDouble(), 15.0)
    }

    @Test
    fun minus() {
        val result = testRestTemplate.getForEntity("/calc/minus",String::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body?.toDouble(), 0.0)
    }

    @Test
    fun minusSomeValues() {
        val result = testRestTemplate.getForEntity("/calc/minus?a=10&b=5",String::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body?.toDouble(), 5.0)
    }

    @Test
    fun divide() {
        val result = testRestTemplate.getForEntity("/calc/divide",String::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body?.toDouble(), 0.0)
    }

    @Test
    fun divideSomeValues() {
        val result = testRestTemplate.getForEntity("/calc/divide?a=10&b=5",String::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body?.toDouble(), 2.0)
    }

    @Test
    fun divideByZero() {
        val result = testRestTemplate.getForEntity("/calc/divide?a=10&b=0",String::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body, "incorrect value b=0")
    }

    @Test
    fun multiply() {
        val result = testRestTemplate.getForEntity("/calc/multiply",String::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body?.toDouble(), 0.0)
    }

    @Test
    fun multiplySomeValues() {
        val result = testRestTemplate.getForEntity("/calc/multiply?a=10&b=5",String::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body?.toDouble(), 50.0)
    }

    @Test
    fun log() {
        val result = testRestTemplate.getForEntity("/calc/log",String::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body, actionsLogService.printActions())
    }
}