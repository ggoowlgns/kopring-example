package com.jhpark.kopring.inaction

import org.junit.jupiter.api.Test

class ChapterFive {
    @Test
    fun 배열_테스트() {

        val letters = Array<String>(26) { i -> ('a' + i).toString() }
        println("letters: ${letters}")
        println(letters.joinToString(""))

        val strings = listOf("a", "b", "c")
        println("%s/%s/%s".format(*strings.toTypedArray()))

        val squares = IntArray(5) { i -> (i+1) * (i+1) }
        println(squares.joinToString())
    }
}