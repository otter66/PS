fun main() {
    val n = readln().toInt()
    val cows = IntArray(10 + 1) { -1 }
    var count = 0

    repeat(n) {
        val (cowNum, position) = readln().split(" ").map { it.toInt() }

        if (cows[cowNum] == -1) cows[cowNum] = position
        else if (cows[cowNum] != position) {
            count++
            cows[cowNum] = position
        }
    }

    println(count)
}

/*
18분 2초 소요
문제를 이해하는데에 시간이 조금 소요되었다. (최소 이동 횟수를 세는 기준)
 */