fun main() {
    val n = readln().toInt()
    val times: MutableList<Pair<Int, Int>> = MutableList(n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        Pair(a, b)
    }
    times.sortBy { it.first }
    var current = times[0].first + times[0].second

    times.forEachIndexed { index, pair ->
        if (index == 0) return@forEachIndexed

        if (current < pair.first) current = pair.first + pair.second
        else current += pair.second
    }

    println(current)

}

/*
13분 소요
 */