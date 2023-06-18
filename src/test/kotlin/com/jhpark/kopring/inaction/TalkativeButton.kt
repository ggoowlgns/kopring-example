package com.jhpark.kopring.inaction


internal open class TalkativeButton {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

//fun TalkativeButton.giveSpeesh() {
//    yell()
//    whisper() // 오류: "whisper"에 접근할 수 없음: "whisper"는 "TalkativeButton"의 "protected" 멤버임
//}