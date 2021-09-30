class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = 0

        for(i in sizes.indices) {
            if(sizes[i][0] < sizes[i][1]) {
                val tmp = sizes[i][0]
                sizes[i][0] = sizes[i][1]
                sizes[i][1] = tmp
            }
        }

        var max1 = -1
        var max2 = -1
        for(i in sizes.indices) {
            if(sizes[i][0] > max1) max1 = sizes[i][0]
            if(sizes[i][1] > max2) max2 = sizes[i][1]
        }

        answer = max1 * max2
        return answer
    }
}