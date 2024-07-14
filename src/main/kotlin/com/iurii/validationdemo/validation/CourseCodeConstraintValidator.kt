package com.iurii.validationdemo.validation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class CourseCodeConstraintValidator : ConstraintValidator<CourseCode, String> {

    private var prefix: String? = null

    override fun initialize(constraintAnnotation: CourseCode?) {
        super.initialize(constraintAnnotation)
        prefix = constraintAnnotation?.value
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {

        return prefix?.let { value?.startsWith(it) } ?: true
    }
}