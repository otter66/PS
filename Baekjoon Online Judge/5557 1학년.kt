fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val dp = MutableList(n) { MutableList(21) { 0L } }
    dp[0][arr[0]]++

    arr.forEachIndexed { currentNumberIndex, currentNumber ->
        if (n - 1 <= currentNumberIndex) return@forEachIndexed
        val nextNumberIndex = currentNumberIndex + 1
        val nextNumber = arr[nextNumberIndex]

        dp[currentNumberIndex].forEachIndexed { i, count ->
            if (i + nextNumber <= 20) dp[nextNumberIndex][i + nextNumber] += count
            if (0 <= i - nextNumber) dp[nextNumberIndex][i - nextNumber] += count
        }
    }

    println(dp[n - 2][arr[n - 1]])
}

/*
1시간 27분 소요
인덱스를 찾는데 시간이 조금 걸렸다
 */
