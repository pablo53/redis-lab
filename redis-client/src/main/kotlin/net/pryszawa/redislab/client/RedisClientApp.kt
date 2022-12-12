package net.pryszawa.redislab.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["net.pryszawa.redislab.client"])
class RedisClientApp

fun main(vararg args: String) {
    runApplication<RedisClientApp>(*args)
}
