fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val board = Array(n) { intArrayOf() }
    for(i in 0 until n) {
        board[i] = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    }

    // sum
    val sum = Array(n+1) { IntArray(n+1) {0} }
    for(i in 1 .. n) {
        for(j in 1 .. n) {
            sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + board[i-1][j-1]
        }
    }

    for(i in 0 until m) {
        val (startX, startY, endX, endY) = readLine()!!.split(" ").map { it.toInt() }
        println(
            sum[endX][endY]
            - sum[endX][startY-1]
            - sum[startX-1][endY]
            +sum[startX-1][startY-1])
    }
}