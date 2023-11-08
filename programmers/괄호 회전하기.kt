import java.util.Stack

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var str: StringBuilder = StringBuilder(s)

        for(i in 0 until s.length) {
            if (isRight(str.toString())) answer++
            str.append(str[0])
            str = StringBuilder(str.removeRange(0, 1).toString())
        }

        return answer
    }

    fun isRight(str: String): Boolean {
        val s: Stack<Char> = Stack()

        for (i in 0 until str.length) {
            if (s.isEmpty()) {
                s.push(str[i])
                continue
            }
            val sTop = s.peek()
            if (sTop == '(' && str[i] == ')'
                || sTop == '{' && str[i] == '}'
                || sTop == '[' && str[i] == ']') {
                s.pop()
            }
            else s.push(str[i])
        }

        return s.size == 0
    }
}