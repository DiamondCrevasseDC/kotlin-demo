package com.lingye.demo.controller

import com.google.common.cache.Cache
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/greeter")
class GreeterController(
    val guavaCache: Cache<String, Any>
) {

//    @Autowired
//    private lateinit var guavaCache: Cache<String, Any>

    @GetMapping("/hello")
    fun hello(): String {
        guavaCache.put("greet", "hello world!")
        return "ok"
    }

    @GetMapping("/helloCache")
    fun helloCache(): String = guavaCache.get("greet") {
             "hello cache!"
        } as String
}