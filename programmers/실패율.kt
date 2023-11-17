class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        val answer: MutableList<Int> = mutableListOf()
        var failRates: MutableList<Pair<Int, Float>> = mutableListOf()
        val stagePlayers: MutableList<Int> = MutableList(N + 2) { 0 }

        stages.forEach { stage ->
            stagePlayers[stage]++
        }

        for (i in 1 .. N) {
            var playerSum = 0
            for (j in i .. N + 1) { playerSum += stagePlayers[j] }

            if (stagePlayers[i] == 0 || playerSum == 0) failRates.add(Pair(i, 0f))
            else failRates.add(Pair(i, stagePlayers[i] / playerSum.toFloat()))
        }

        failRates.sortedWith( compareBy({-it.second}, {it.first}) ).forEach {
            answer.add(it.first)
        }

        return answer.toList().toIntArray()
    }
}