package com.jhpark.kopring.inaction

import org.junit.jupiter.api.Test
import kotlin.RuntimeException
import com.jhpark.kopring.inaction.ChapterThree.Companion.lastChar
import io.kotest.matchers.shouldBe

class ChapterOne {
    // 데이터 클래스
    data class Person(
        val name: String,
        val age: Int? = null, // 널이 될 수 있는 타입과 파라미터 디폴트 값 (여기서는 null)
        val charecters: List<String>? = listOf()
    )

    // 최상위 함수
    @Test
    fun `Ch1 Main`() {
        val persons = listOf(
            Person("Alice"),
            Person("Bob", age = 29) // 이름 붙은 파라미터
        )
        val oldest = persons.maxBy { it.age ?: 0 } // 람다 식과 엘비스 연산자
         //Elvis operator is a shorthand for handling nullable values
        println("The oldest is: $oldest") // 문자열 템플릿
        val javaCode = TestingJavaCode()
        javaCode.print()

        "Kotling".lastChar() shouldBe 'g'

        try {
            throw RuntimeException("?")
        } catch (e: RuntimeException) {
            println("In Catch block")
            return;
        }
        //catch 문에서 return 을 사용했기에 아래는 프린팅X
        println("After Catch block")


    }

}