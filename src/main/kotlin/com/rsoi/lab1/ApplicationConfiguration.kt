package com.rsoi.lab1

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import java.util.logging.Logger

@Configuration
@ComponentScan
class ApplicationConfiguration {
    @Bean
    @Primary
    fun logger() : Logger {
        return  Logger.getLogger("APP")
    }
}