package com.jhpark.kopring.note

import org.junit.jupiter.api.Test

class FunctionTest {
    @Test
    fun namedArgumentTest() {
        multiArgumentFunction(
            arg2 = "",
            arg4 = Any()
        )
    }

    private fun multiArgumentFunction(
        arg1: Int = 1,
        arg2: String,
        arg3: Long = 1L,
        arg4: Any
    ) {
        println("""
            arg1:${arg1}
            arg2:${arg2}
            arg3:${arg3}
            arg4:${arg4}
            """.trimIndent()
        )
    }
}