import kotlin.math.min

fun main(args: Array<String>) {
    val MAX = Int.MAX_VALUE
    val n: Int = readln().toInt()
    val str: String = readln()
    val dp: IntArray = IntArray(n) { MAX }
    dp[0] = 0

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (!isMovable(str[j].toString(), str[i].toString())) continue
            if (dp[j] == MAX) continue
            val distance = i - j
            dp[i] = min(dp[i], distance * distance + dp[j])
        }
    }

    if (dp[n - 1] == MAX) println(-1)
    else println(dp[n - 1])
}

fun isMovable(before: String, after: String): Boolean {
    val seq: Array<String> = arrayOf("B", "O", "J")
    val seqBeforeIndex = seq.indexOf(before)
    val seqAfterIndex = seq.indexOf(after)
    if (seqBeforeIndex == -1 || seqAfterIndex == -1) return false
    if (seqBeforeIndex == seq.size - 1) return seqAfterIndex == 0
    return seqBeforeIndex + 1 == seqAfterIndex
}