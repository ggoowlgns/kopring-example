package com.jhpark.kopring

import com.jhpark.kopring.inaction.ChapterOne
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringExampleApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringExampleApplication>(*args)
    val chOne = ChapterOne()
    chOne.main()
}
