package ru.corthoscode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("flapdoodle")
@SpringBootTest
class Flapdoodle_CustomerRepositoryTest {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @BeforeEach
    fun removeAllData() {
        customerRepository.deleteAll()
    }

    @Test
    fun `should save and find customer`() {
        val customer = Customer("111", "Test", "Test", "Email")
        val result = customerRepository.insert(customer)
        assertThat(result).isEqualTo(customer)

        val all = customerRepository.findAll()
        assertThat(all.count()).isEqualTo(1)
    }
}