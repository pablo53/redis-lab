package net.pryszawa.redislab.client

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class RedisController(
    private val redisService: RedisService,
) {

    companion object {
        @JvmStatic
        private var LOGGER = LoggerFactory.getLogger(RedisController::class.java)
    }

    @GetMapping("/echo/{message}")
    fun getEcho(@PathVariable("message") message: String): ResponseEntity<String> {
        LOGGER.info("Echo endpoint called with message: $message")
        val retMsg = redisService.getEcho(message = message)
        return ResponseEntity.ok(retMsg)
    }

}