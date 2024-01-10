import kotlin.math.sqrt

val firsts: IntArray = intArrayOf(2, 3, 5, 7)
val holSues: IntArray = intArrayOf(1, 3, 5, 7, 9)
val results: MutableList<Int> = mutableListOf()

fun main(args: Array<String>) {
    val n: Int = readln().toInt()

    for (i in 0 until firsts.size) {
        val currentNum = firsts[i]
        dfs(n, 1, currentNum)
    }

    results.sort()
    results.forEach {
        println(it)
    }
}

fun dfs(len: Int, depth: Int, number: Int) {
    val isSoSu = isSoSu(number)
    if (!isSoSu) return
    if (len == depth) results.add(number)

    for (i in 0 until holSues.size) {
        val next: Int = number * 10 + holSues[i]
        dfs(len, depth + 1, next)
    }
}

fun isSoSu(number: Int): Boolean {
    if (number < 2) return false
    sqrt(number.toDouble())
    for (i in 2..sqrt(number.toDouble()).toInt()) {
        if (number % i == 0) return false
    }
    return true
}
