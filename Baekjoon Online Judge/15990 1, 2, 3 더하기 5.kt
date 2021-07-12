const val mod = 1000000009
val dp = Array(100001) { LongArray(4) { 0 } }

fun main() {
    var t = readLine()!!.toInt()

    solve()
    while (t > 0) {
        t--
        val n = readLine()!!.toInt()

        println((dp[n][1] + dp[n][2] + dp[n][3]) % mod)
    }
}

fun solve() {
    dp[1][1] = 1
    dp[2][2] = 1
    dp[3][1] = 1
    dp[3][2] = 1
    dp[3][3] = 1

    for(i in 4..100000) {
        dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod
        dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod
        dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod
    }
}

