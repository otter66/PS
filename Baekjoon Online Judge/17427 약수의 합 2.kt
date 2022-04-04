fun main() {
    val n = readLine()!!.toInt()
    var sum: Long = 0

    for (i in 1..n) {
        sum += n / i * i
    }

    print(sum)
}