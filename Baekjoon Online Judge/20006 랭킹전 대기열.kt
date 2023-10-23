import kotlin.math.abs

fun main() {
    val (playerNumber, m) = readln().split(" ").map { it.toInt() }
    val matched: MutableList<MutableList<Pair<Int, String>>> = mutableListOf()

    for (i in 0 until playerNumber) {
        val (l_tmp, n) = readln().split(" ")
        val l = l_tmp.toInt()
        val player = Pair(l, n)
        val matchIndex = getMatchIndex(m, player, matched)

        if (matchIndex < 0) matched.add(mutableListOf(player))
        else matched[matchIndex].add(player)
    }

    matched.forEach { players ->
        if (players.size == m) println("Started!")
        else println("Waiting!")

        players.sortBy { it.second }
        players.forEach {
            println("${it.first} ${it.second}")
        }
    }
}

fun getMatchIndex(m: Int, player: Pair<Int, String>, matched: List<List<Pair<Int, String>>>): Int {
    var matchedIndex = -1

    for(index in matched.indices) {
        val currentMatch = matched[index]
        if (m <= currentMatch.size) continue

        val isMatchable = isMatchable(player, currentMatch[0])
        if (isMatchable) {
            matchedIndex = index
            break
        }
    }

    return matchedIndex
}

fun isMatchable(player: Pair<Int, String>, matchPlayer: Pair<Int, String>): Boolean {
    var flag: Boolean = true
    if (10 < abs(matchPlayer.first - player.first)) flag = false
    return flag
}

/*
문제를 제대로 안읽었다...
때문에 1시간 30분 ~ 2시간 걸린 것 같다.
방의 첫번째 사람 기준으로 +-10분이었지만, 방의 전체를 검사하고 있었다... 문제를 잘 읽자 ^^
 */