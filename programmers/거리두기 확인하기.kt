class Solution {
    fun solution(places: Array<Array<String>>): IntArray {
        var answer: MutableList<Int> = mutableListOf()

        places.forEach { place ->
            var a = 1
            for(i in 0 until 5) {
                for(j in 0 until 5) {
                    if (place[i][j] != 'P') continue
                    if (isAble(place, i, j).not()) a = 0
                }
            }
            answer.add(a)
        }

        return answer.toIntArray()
    }

    fun isAble(room: Array<String>, PX: Int, PY: Int): Boolean {
        val dx: List<Int> = listOf(-2, -1, -1, 0, 0, 1, 2, 1,  1,  0,  0, -1)
        val dy: List<Int> = listOf( 0,  0,  1, 2, 1, 1, 0, 0, -1, -2, -1, -1)
        val dkx: List<List<Int>> = listOf(
            listOf(-1), listOf(), listOf(-1, 0), listOf(0), listOf(), listOf(0,  1),
            listOf( 1), listOf(), listOf( 1, 0), listOf(0), listOf(), listOf(-1, 0)
        )
        val dky: List<List<Int>> = listOf(
            listOf(0), listOf(), listOf(0,  1), listOf( 1), listOf(), listOf(1,  0),
            listOf(0), listOf(), listOf(0, -1), listOf(-1), listOf(), listOf(0, -1)
        )

        for(i in 0 until dx.size) {
            if (PX + dx[i] < 0 || 5 <= PX + dx[i]) continue
            if (PY + dy[i] < 0 || 5 <= PY + dy[i]) continue

            val s1 = room[PX + dx[i]][PY + dy[i]]
            if (s1 != 'P') continue

            if (dkx[i].size == 0) return false
            for(j in 0 until dkx[i].size) {
                val s2 = room[PX + dkx[i][j]][PY + dky[i][j]]
                if (s2 != 'X') return false
            }
        }

        println()

        return true
    }
}