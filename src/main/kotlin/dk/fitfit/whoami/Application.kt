package dk.fitfit.whoami

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.runtime.Micronaut
import mu.KotlinLogging
import java.net.InetAddress
import javax.inject.Singleton

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
class WhoAmIController(private val whoAmIService: WhoAmIService) {
    @Get(value = "/", produces = ["text/html;charset=UTF-8"])
    fun whoAmI(): String {
        logger.info("Whoami request")
        return whoAmIService.whoAmI()
    }
}

interface WhoAmIService {
    fun whoAmI(): String
}

@Singleton
class WhoAmIServiceImpl: WhoAmIService {
    override fun whoAmI(): String = InetAddress.getLocalHost().hostName
}
