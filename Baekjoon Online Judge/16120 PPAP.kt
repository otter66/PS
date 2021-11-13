import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main() {
    val br = BufferedReader(BufferedReader(InputStreamReader(System.`in`)))
    val str = StringBuilder(br.readLine())
    val stack: Stack<Char> = Stack()

    for(i in str.indices) {
        stack.push(str[i])

        if(stack.size < 4) continue
        if(stack[stack.lastIndex] == 'P'
            && stack[stack.lastIndex - 1] == 'A'
            && stack[stack.lastIndex - 2] == 'P'
            && stack[stack.lastIndex - 3] == 'P') {
            for(j in 0 until 3) stack.pop()
        }
    }

    if(stack.size == 1 && stack[0] == 'P') print("PPAP")
    else print("NP")
}