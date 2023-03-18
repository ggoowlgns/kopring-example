package com.jhpark.kopring.controller

import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/v1")
@RestController
class HomeController {

    @RequestMapping("/test", method = [RequestMethod.GET])
    fun test() = HttpStatus.OK
}