fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val bulbs = readln().split(" ").map { it.toInt() }.toMutableList()

    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        when (a) {
            1 -> {
                bulbs[b - 1] = c
            }

            2 -> {
                for (i in b..c) {
                    bulbs[i - 1] = if (bulbs[i - 1] == 0) 1 else 0
                }
            }

            3 -> {
                for (i in b..c) {
                    bulbs[i - 1] = 0
                }
            }

            4 -> {
                for (i in b..c) {
                    bulbs[i - 1] = 1
                }
            }
        }
    }

    println(bulbs.joinToString(" "))
}

/*
18분 8초 소요

불필요하게 시간이 걸린 부분 :
- 최적화를 하려고 한 것.
    - int가 아닌 byte를 사용하려고 해서 여기저기서 바꿔야했음. 문제에서 불필요한 최적화는 생각하지 말 것
 */

