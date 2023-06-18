package com.jhpark.kopring.concurrencykotlin

import io.kotest.common.runBlocking
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.jupiter.api.Test

class CoroutineTest {
    @Test
    fun coroutineConcurrencySeq() = kotlinx.coroutines.runBlocking {
        launch {
            action1("launch")
            action2("launch")
            action3("launch")
        }
        async {
            action1("async")
            action2("async")
            action3("async")
        }
        delay(1000)
        println("out 1 - ${Thread.currentThread().name}")
        delay(1000)
        println("out 2 - ${Thread.currentThread().name}")
        delay(1000)
        println("out 3 - ${Thread.currentThread().name}")
    }
    suspend fun action1(launchedBlock: String) {
        delay(1000)
        println("$launchedBlock action1 - ${Thread.currentThread().name}")
    }
    suspend fun action2(launchedBlock: String) {
        delay(1000)
        println("$launchedBlock action2 - ${Thread.currentThread().name}")
    }

    suspend fun action3(launchedBlock: String) {
        delay(1000)
        println("$launchedBlock  action3 - ${Thread.currentThread().name}")
    }
}