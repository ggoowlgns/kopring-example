package com.jhpark.kopring.concurrencykotlin

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class ChapterOne {
    @Test
    fun coroutineSimpleTest() = runBlocking {
        println("${Thread.activeCount()} threads active at the start")
        val time = measureTimeMillis {
            createCoroutines(10000)
        }
        println("${Thread.activeCount()} threads active at end")
        println("Took $time ms")
    }

    suspend fun createCoroutines(amount: Int) {
        val jobs = ArrayList<Job>()
        for (i in 1..amount) {
            jobs += GlobalScope.launch {
                println("Started $i in ${Thread.currentThread().name}")
                delay(1000)
                println("Finished $i in ${Thread.currentThread().name}")
            }
        }
        jobs.forEach {
            it.join()
        }
    }

    @Test
    fun coroutineSequentialRunning() = runBlocking {
        val time = measureTimeMillis {
            val name = getName()
            val lastName = getLastName()

            println("Hello, ${name} ${lastName}")
        }
        val deffered = async {  }
        println("Execution took $time ms")
    }

    @Test
    fun coroutineConcurrencyRunning() = runBlocking {
        val time = measureTimeMillis {
            val name = async { getName() }
            val lastName = async { getLastName() }

            println("Hello, ${name.await()} ${lastName.await()}")
        }

        println("Execution took $time ms")
    }

    suspend fun getName(): String {
        println("Started getName() in ${Thread.currentThread().name}")
        delay(1000)
        println("Finished getName() in ${Thread.currentThread().name}")
        return "Susan"
    }

    suspend fun getLastName(): String {
        println("Started getLastName() in ${Thread.currentThread().name}")
        delay(1000)
        println("Finished getLastName() in ${Thread.currentThread().name}")
        return "Calvin"
    }

    @Test
    fun jobAndDeferredTest() = runBlocking {
        println("in main : ${Thread.currentThread().name}")
        val job = launch {
            delay(1000)
            println("in job : ${Thread.currentThread().name}")
        }
        val deferred = async {
            delay(1000)
            println("in deferred : ${Thread.currentThread().name}")
        }
    }

    @Test
    fun deferredExceptionTest() = runBlocking {
        val deferred = async {
            throw Exception("exception in async block")
            return@async true
        }
        try {
            if (deferred.isCancelled) return@runBlocking
            deferred.join()
        } catch (e: Exception) {
            println(e)
        }

        println("outside")
    }

    suspend fun concurrencyCall(): Boolean {
        coroutineScope {
            return@coroutineScope true
        }
        return true
    }
}