package com.rsoi.lab1.Controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger


@Controller()
@RequestMapping(value = "/")
class MainController {

    @Autowired
    lateinit var environment: Environment

    @Autowired
    lateinit var logger: Logger;

    @GetMapping()
    @ResponseBody
    fun main(): String {
        logger.info("request /")
        return "Rsoi lab 1; port: "+environment.getProperty("local.server.port")
    }
}