package dk.fitfit.whoami

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@MicronautTest
internal class WhoAmIControllerTest(private val whoAmIClient: WhoAmIClient) {

    @Test
    fun `Perform HTTP get request to root`() {
        // Given
        val expectedHostname = "hostname"

        // When
        val response = whoAmIClient.getWhoAmI()

        // Then
        val actualHostname = response.body.get()
        assertEquals(expectedHostname, actualHostname)
    }

    @Test
    fun `Perform HTTP get request to health endpoint`() {
        // Given
        val expectedStatus = "UP"

        // When
        val response = whoAmIClient.getHealth()

        // Then
        val health = response.body.get()
        val actualStatus = health.status
        assertEquals(expectedStatus, actualStatus)
    }

}

class Health(val status: String)

@Client("/")
interface WhoAmIClient {
    @Get("/")
    fun getWhoAmI(): HttpResponse<String>

    @Get("/health")
    fun getHealth(): HttpResponse<Health>
}
