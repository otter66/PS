fun main() {
    val n = readLine()!!.toInt()
    val dp = Array(101) { IntArray(11) { 0 } }
    var result = 0

    for(i in 1 .. 9) { dp[1][i] = 1 }

    for(i in 2..n) {
        for(j in 0 .. 9) {
            when (j) {
                0 -> dp[i][j] = dp[i-1][j+1]
                9 -> dp[i][j] = dp[i-1][j-1]
                else -> {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000
                }
            }
        }
    }

    for(i in 0 .. 9) result = (result + dp[n][i]) % 1000000000
    print(result)
}