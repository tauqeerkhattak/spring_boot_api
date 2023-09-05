package com.mania.web_demo.controllers

import com.mania.web_demo.resources.EventModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class RestController {
    private var template: String = "Hello, %s!"
    private var counter: AtomicLong = AtomicLong();

    @GetMapping("/api/event")
    fun getEvent(@RequestParam(value = "name", defaultValue = "World") name: String): EventModel {
        return EventModel(counter.incrementAndGet(), String.format(template, name))
    }
}