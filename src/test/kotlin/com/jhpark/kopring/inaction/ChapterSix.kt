package com.jhpark.kopring.inaction

import org.junit.jupiter.api.Test
import kotlin.properties.Delegates

class ChapterSix {

    @Test
    fun `위임_클래스_lazy_로 구현`() {
        val person1 = Person("jhpark", 30)
        println("person1: ${person1}")
        println("person1.email: ${person1.email}")
    }

    @Test
    fun 프로퍼티_변경_감지_테스트() {
        val person1 = Person("jhpark", 30)
        for (i in 1..10) {
            person1.observableField += i
        }
        println("person1.obs~ : ${person1.observableField}")

        for (i in 1..100) {
            person1.vetoableField = i
        }
        println("person1.vetoable : ${person1.vetoableField}")
    }

    data class Person(
        val name: String,
        val age: Int,
    ) {
        var observableField: Int by Delegates.observable(0) { property, old, new ->
            println("old: $old, new: $new")
        }
        var vetoableField: Int by Delegates.vetoable(0) { property, old, new ->
            println("old: $old, new: $new")
            return@vetoable new % 2 == 0
        }
        val email by lazy {
            println("making email")
            return@lazy "$name@km.com"
        }
    }
}