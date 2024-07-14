package com.iurii.validationdemo.controller

import com.iurii.validationdemo.model.Customer
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class CustomerController {
    @GetMapping("/")
    fun showForm(model: Model): String {
        model.addAttribute("customer", Customer())
        return "customer/form"
    }
}