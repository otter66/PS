import kotlin.math.max

fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    val arr: List<Int> = (MutableList(n) { readln().toInt() }).sorted()

    var start = 1
    var end = arr[n - 1]
    var best = 0

    while (start <= end) {
        val mid = (start + end) / 2

        var count = 1
        var lastLocate = arr[0]
        for (i in 1 until n) {
            val locate = arr[i]
            if (mid <= locate - lastLocate) {
                count++
                lastLocate = locate
            }
        }

        if (c <= count) {
            start = mid + 1
            best = max(mid, best)
        } else end = mid - 1
    }

    println(best)
}

/*
약 1시간 30분 소요
피곤해서 나사 빠진채로 풀어서 그런건지 단지 능지 이슈인건지 모르겠다.
문제 이해 후 해결 방법을 10분 이상 고민했는데도 떠오르지 않아 답지를 봤다.
답지를 봤는데도 30%쯤에서 틀렸다.
다음날 아침 start를 arr[0]이 아닌 1로 시작하여 맞았다.
그런데 그냥 피곤 이슈였던 것 같다. 평소보다 두배는 자고 보니 이해가 된다.
 */