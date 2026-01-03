package ru.corthoscode

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Customer(
    @Id
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String
)
