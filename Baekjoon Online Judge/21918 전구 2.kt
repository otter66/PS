fun main() {
    val (_, m) = r()
    val bulbs = r().toIntArray()

    repeat(m) {
        val (a, b, c) = r()
        when (a) {
            1 -> bulbs[b - 1] = c
            2 -> for (i in b..c) bulbs[i - 1] = bulbs[i - 1] xor 1
            3 -> for (i in b..c) bulbs[i - 1] = 0
            4 -> for (i in b..c) bulbs[i - 1] = 1
        }
    }

    println(bulbs.joinToString(" "))
}

fun r() = readln().split(' ').map { it.toInt() }