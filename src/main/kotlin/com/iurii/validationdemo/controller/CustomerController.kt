package com.iurii.validationdemo.controller

import com.iurii.validationdemo.model.Customer
import jakarta.validation.Valid
import org.springframework.beans.propertyeditors.StringTrimmerEditor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class CustomerController {

    @GetMapping("/")
    fun showForm(model: Model): String {
        model.addAttribute("customer", Customer())
        return "customer/form"
    }

    @RequestMapping("/register")
    fun register(
        @Valid @ModelAttribute("customer") customer: Customer,
        bindingResult: BindingResult,
    ): String {
        return if (bindingResult.hasErrors()) {
            "customer/form"
        } else {
            "customer/register"
        }
    }

    @InitBinder
    fun initBinder(binder: WebDataBinder) {
        val editor = StringTrimmerEditor(true)
        binder.registerCustomEditor(String::class.java, editor)
    }
}