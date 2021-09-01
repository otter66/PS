class Solution {
    fun solution(scores: Array<IntArray>): String {
        var answer: String = ""

        for (j in scores.indices) {
            var sum = 0
            var stdNum = scores.size
            var maxValue = -1
            var minValue = 101
            for (i in scores[j].indices) {
                if (maxValue < scores[i][j]) maxValue = scores[i][j]
                if (minValue > scores[i][j]) minValue = scores[i][j]
                sum += scores[i][j]
            }

            var maxCount = 0
            var minCount = 0
            for (i in scores[j].indices) {
                if (maxValue == scores[i][j]) maxCount++
                if (minValue == scores[i][j]) minCount++
            }

            if ((scores[j][j] == maxValue && maxCount == 1) || (scores[j][j] == minValue && minCount == 1)) {
                stdNum--
                sum -= scores[j][j]
            }

            answer +=
                when (sum / stdNum) {
                    in 90..100 -> "A"
                    in 80..89 -> "B"
                    in 70..79 -> "C"
                    in 50..69 -> "D"
                    else -> "F"
                }
        }

        return answer
    }
}