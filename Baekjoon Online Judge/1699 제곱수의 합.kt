import java.lang.Integer.min

fun main() {
    val n = readLine()!!.toInt()
    val dp = IntArray(n + 1) { 0 }

    for (i in 1..n) {
        dp[i] = i
        var j = 1
        while (j * j <= i) {
            dp[i] = min(dp[i], dp[i - j * j] + 1)
            j++
        }
    }

    print(dp[n])
}