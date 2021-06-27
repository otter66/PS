fun main() {
    val dp = IntArray(1002) {0}
    dp[1] = 1
    dp[2] = 3
    val n = readLine()!!.toInt()

    for(i in 3 .. n) {
        dp[i] = ( dp[i-2]*2 + dp[i-1] ) % 10007
    }

    print(dp[n])
}
