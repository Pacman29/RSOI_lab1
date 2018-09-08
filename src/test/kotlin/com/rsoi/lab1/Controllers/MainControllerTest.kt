package com.rsoi.lab1.Controllers

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MainControllerTest {
    @Autowired
    lateinit var environment: Environment
    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun main() {
        val result = testRestTemplate.getForEntity("/",String::class.java)
        assertNotNull(result)
        assertEquals(result.statusCode, HttpStatus.OK)
        assertEquals(result.body, "Rsoi lab 1; port: "+environment.getProperty("local.server.port"))
    }
}