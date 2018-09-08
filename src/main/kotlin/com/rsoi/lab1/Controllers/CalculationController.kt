package com.rsoi.lab1.Controllers

import com.rsoi.lab1.Models.ActionModel
import com.rsoi.lab1.Services.ActionsLogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger


@Controller()
@RequestMapping(value = "/calc")
class CalculationController {
    @Autowired
    lateinit var actionsLogService: ActionsLogService;

    @Autowired
    lateinit var logger : Logger

    @GetMapping()
    @ResponseBody
    fun info () : String {
        logger.info("request /calc/")
        return "this is calculation controller"
    }

    @GetMapping(value = "/plus")
    @ResponseBody
    fun plus(
            @RequestParam(value = "a", defaultValue = "0") a: Double,
            @RequestParam(value = "b", defaultValue = "0") b: Double): String {
        logger.info("request /calc/plus")
        val result = a+b
        actionsLogService.addAction(ActionModel("plus",a,b,result))
        return result.toString();
    }

    @GetMapping(value = "/minus")
    @ResponseBody
    fun minus(
            @RequestParam(value = "a", defaultValue = "0") a: Double,
            @RequestParam(value = "b", defaultValue = "0") b: Double): String {
        logger.info("request /calc/minus")
        val result = a-b
        actionsLogService.addAction(ActionModel("minus",a,b,result))
        return result.toString();
    }

    @GetMapping(value = "/divide")
    @ResponseBody
    fun divide(
            @RequestParam(value = "a", defaultValue = "0") a: Double,
            @RequestParam(value = "b", defaultValue = "1") b: Double): String {
        logger.info("request /calc/divide")
        if(b == 0.0)
            return "incorrect value b=0"
        val result = a/b
        actionsLogService.addAction(ActionModel("divide",a,b,result))
        return result.toString();
    }

    @GetMapping(value = "/multiply")
    @ResponseBody
    fun multiply(
            @RequestParam(value = "a", defaultValue = "0") a: Double,
            @RequestParam(value = "b", defaultValue = "0") b: Double): String {
        logger.info("request /calc/multiply")
        val result = a*b
        actionsLogService.addAction(ActionModel("multiply",a,b,result))
        return result.toString();
    }

    @GetMapping(value = "/log")
    @ResponseBody
    fun log(): String {
        logger.info("request /calc/log")
        return actionsLogService.printActions();
    }
}