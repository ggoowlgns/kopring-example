package com.jhpark.kopring.inaction

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

/**
 * 함수 정의와 호출
 */
class ChapterThree {
    companion object {
        fun String.lastChar(): Char = this.get(this.length - 1)
        var StringBuilder.lastChar: Char
            get() = get(length - 1)
            set(value: Char) {
                this.setCharAt(length - 1, value)
            }
    }

    @Test
    fun `확장 함수`() {
        "Kotlin".lastChar() shouldBe 'n'
    }

    @Test
    fun `확장 프로퍼티`() {
        val sb = StringBuilder("Kotlin?")
        sb.lastChar = '!'

        sb.toString() shouldBe "Kotlin!"
    }

    fun <T> listOf(vararg elements: T): List<T> = if (elements.size > 0) elements.asList() else emptyList()
    @Test
    fun `가변 인자`() {
        val list = listOf("one", "two", "three")
        val arr = arrayOf(list)
        println(listOf("args : ", *arr))
        list shouldBe kotlin.collections.listOf<String>("one", "two", "three")
    }


    // 중위 함수는 반드시 확장함수 + 인자 1개 여야 한다.
    infix fun Int.addTwo(a: Int) = this+a
    @Test
    fun `중위 호출`() {
        1 addTwo 2 shouldBe 3
    }
}