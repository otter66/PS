import java.lang.StringBuilder

fun main() {
    val n8 = readln()
    val binary = listOf("000", "001", "010", "011", "100", "101", "110", "111")
    val result = StringBuilder()

    if (n8 == "0") {
        println(0)
        return
    }

    n8.forEach {
        result.append(binary[it.digitToInt(radix = 8)])
    }

    println(result.trimStart { it == '0' })
}

/*
26분 13초 소요
 */

