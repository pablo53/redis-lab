package net.pryszawa.redislab.client

import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class RedisService {

    companion object {
        @JvmStatic
        private var LOGGER = LoggerFactory.getLogger(RedisService::class.java)
    }

    @Cacheable("echos")
    fun getEcho(message: String): String {
        val retMsg = "Received message: $message"
        LOGGER.info(retMsg)
        return retMsg
    }

}