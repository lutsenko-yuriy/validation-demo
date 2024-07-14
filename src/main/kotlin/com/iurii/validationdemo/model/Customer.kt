package com.iurii.validationdemo.model

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class Customer(
    var firstName: String? = null,
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    var lastName: String = "",
)
