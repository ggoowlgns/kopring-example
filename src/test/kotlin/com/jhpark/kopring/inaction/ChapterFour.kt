package com.jhpark.kopring.inaction

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.kotest.matchers.types.shouldBeSameInstanceAs
import org.junit.jupiter.api.Test
import java.awt.SystemColor.window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.io.File

class ChapterFour: ParentClass() {
    @Test
    fun 중첩클래스_using_SealedClass() {
        eval(SealedExpr.Num(7)) shouldBe 7
    }

    @Test
    fun 싱글톤() {
        CaseInsensitiveFileComparator.compare(File("../../../build.gradle.kts"), File("../../../build.gradle.kts"))
    }

    @Test
    fun anonymous_class_with_multi_interface() {

        val anonymousObject = object : MouseAdapter(), Interface2, Interface1 {
                override fun mouseClicked(e: MouseEvent) { TODO("Not yet implemented") }
                override fun mouseEntered(e: MouseEvent) { TODO("Not yet implemented") }
                override fun method1() {
                    TODO("Not yet implemented")
                }

                override fun method2() {
                    TODO("Not yet implemented")
                }
            }

        val result = anonymousObject is Interface1
        result shouldBe true
    }
}
interface Interface1 {
    fun method1()
}

interface Interface2 {
    fun method2()
}


object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path,
            ignoreCase = true)
    }
}

open class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

sealed class SealedExpr {
    class Num(val value: Int) : SealedExpr()
    class Sum(val left: SealedExpr, val right: SealedExpr) : SealedExpr()
}

fun eval(e: SealedExpr): Int =
    when (e) {
        is SealedExpr.Num -> e.value
        is SealedExpr.Sum -> eval(e.right) + eval(e.left)
    }