import java.util.Stack

fun main() {
    val score: Map<Char, Int> = mapOf(
        '(' to 2, ')' to 2,
        '[' to 3, ']' to 3
    )

    val str: String = readln()
    val s: Stack<Char> = Stack()
    var tmp = 1
    var result = 0

    for (i in 0 until str.length) {
        when (val current = str[i]) {
            '(', '[' -> {
                s.push(current)
                tmp *= score[current]!!
            }
            ')', ']' -> {
                if (i == 0 || s.empty() ||
                    current == ')' && s.peek() != '(' ||
                    current == ']' && s.peek() != '['
                ) {
                    println(0)
                    return
                }
                if (current == ')' && str[i - 1] == '(') result += tmp
                else if (current == ']' && str[i - 1] == '[') result += tmp
                s.pop()
                tmp /= score[current]!!
            }
        }
    }

    if (s.isNotEmpty()) println(0)
    else println(result)
}