fun main() {
    val n = readLine()!!.toInt()
    val dp = Array(1001) { IntArray(11) { 0 } }
    var result = 0

    for (i in 0..9) dp[1][i] = 1

    for(k in 2 .. n) {
        for(i in 0 .. 9) {
            for(j in 0 .. i) {
                dp[k][i] += dp[k-1][j]
                dp[k][i] %= 10007
            }
        }
    }

    for(i in 0 .. 9) {
        result += dp[n][i]
        result %= 10007
    }
    print(result)
}