val memo = LongArray(91) {0}

fun main() {
    val n = readLine()!!.toInt()

    print(fib(n))
}

fun fib(n: Int): Long {
    if(n <= 1) return n.toLong()
    if(memo[n] > 0) return memo[n]

    memo[n] = fib(n-1) + fib(n-2)
    return memo[n]
}
