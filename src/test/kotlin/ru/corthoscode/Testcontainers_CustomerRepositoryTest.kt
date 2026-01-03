package ru.corthoscode

import de.flapdoodle.embed.mongo.spring.autoconfigure.EmbeddedMongoAutoConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.ClassRule
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.test.context.ActiveProfiles
import org.testcontainers.containers.MongoDBContainer

@ActiveProfiles("testcontainers")
@DataMongoTest(excludeAutoConfiguration = [EmbeddedMongoAutoConfiguration::class])
class Testcontainers_CustomerRepositoryTest {

    companion object {
        @JvmStatic
        @ClassRule
        val mongoDBContainer: MongoDBContainer = MongoDBContainerInitializer.initialize()
    }

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