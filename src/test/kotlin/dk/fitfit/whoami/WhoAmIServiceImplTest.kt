package dk.fitfit.whoami

import io.micronaut.test.annotation.MicronautTest
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.net.InetAddress

@MicronautTest
internal class WhoAmIServiceImplTest {

    private val whoAmIService = WhoAmIServiceImpl()

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `whoAmI method of whoAmIService behaves as expected`() {
        // Given
        val expectedHostname = "hostname"

        mockkStatic(InetAddress::class)
        every { InetAddress.getLocalHost().hostName } returns expectedHostname

        // When
        val actualHostname = whoAmIService.whoAmI()

        // Then
        assertEquals(expectedHostname, actualHostname)
    }
}
