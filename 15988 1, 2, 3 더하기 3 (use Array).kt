fun main() {
    var t = readLine()!!.toInt()

    while (t > 0) {
        t--
        val dp = IntArray(1000001) {0}
        dp[1] = 1
        dp[2] = 2
        dp[3] = 4
        val n = readLine()!!.toInt()


        for(i in 4..n) {
            dp[i] = ((dp[i-1].toLong() + dp[i-2] + dp[i-3]) % 1000000009).toInt()
        }

        println(dp[n])
    }
}