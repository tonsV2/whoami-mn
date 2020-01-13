package dk.fitfit.whoami

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.runtime.Micronaut
import mu.KotlinLogging
import java.net.InetAddress

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("dk.fitfit.whoami")
                .mainClass(Application.javaClass)
                .start()
    }
}

private val logger = KotlinLogging.logger {}

@Controller
class WhoamiController {
    @Get("/")
    fun whoami(): String {
        logger.info("Whoami request")
        return InetAddress.getLocalHost().hostName
    }
}
