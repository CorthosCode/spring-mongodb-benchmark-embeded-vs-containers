package ru.corthoscode

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @GetMapping("/customer")
    fun getAllCustomers(): List<Customer> {
        return customerRepository.findAll()
    }
}