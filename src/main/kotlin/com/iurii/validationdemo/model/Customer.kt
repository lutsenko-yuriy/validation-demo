package com.iurii.validationdemo.model

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class Customer(
    var firstName: String? = null,

    @field:NotNull(message = "is required")
    @field:Size(min = 1, message = "is required")
    var lastName: String? = null,

    @field:NotNull(message = "is required")
    @field:Min(value = 0, message = "Must be greater than or equal to 0")
    @field:Max(value = 10, message = "Must be less than or equal to 10")
    var freePasses: Int? = null,

    @field:Pattern(regexp = "^[a-zA-Z0-9]{5}$", message = "Only 5 digits/letters")
    var postalCode: String? = null,
)
