package com.exxeta.hotelmanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain =
            http.csrf()
                    .disable()
                    .authorizeHttpRequests { request -> request.anyRequest().permitAll() }
                    .build()
}

@SpringBootApplication class HotelmanagerApplication

fun main(args: Array<String>) {
    runApplication<HotelmanagerApplication>(*args)
}
