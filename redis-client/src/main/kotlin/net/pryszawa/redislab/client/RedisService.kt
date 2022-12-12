package net.pryszawa.redislab.client

import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class RedisService(
    private val redisTemplate: RedisTemplate<String, String>,
) {

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

    @CacheEvict("echos")
    fun deleteEcho(message: String): String {
        val retMsg = "Unmessaging: $message"
        LOGGER.info(retMsg)
        return retMsg
    }

    @CacheEvict("echos", allEntries = true)
    fun deleteAllEchos(): String {
        val retMsg = "Unmessaging all entries"
        LOGGER.info(retMsg)
        return retMsg
    }

    @CachePut("echos")
    fun putEcho(message: String): String {
        val retMsg = "Put message: $message"
        LOGGER.info(retMsg)
        return retMsg
    }

    fun getAllKeys(): List<String> {
        LOGGER.info("Querying for all keys.")
        val allKeys = redisTemplate.keys("*")
        return allKeys.toList()
    }

    fun getKey(key: String): String {
        LOGGER.info("Querying for key '$key'.")
        val value = redisTemplate.opsForValue()[key]
        return value ?: ""
    }

}