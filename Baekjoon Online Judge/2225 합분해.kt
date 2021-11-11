fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val dp = Array(k + 1) { Array(n + 1) { 0 } }

    for(i in 1 .. n)
        dp[1][i] = 1
    for(i in 1 .. k)
        dp[i][1] = i

    for(i in 2 .. k) {
        for(j in 2 .. n) {
            dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000
        }
    }

    print(dp[k][n])
}