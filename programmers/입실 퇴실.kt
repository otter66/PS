class Solution {
    lateinit var check: Array<IntArray>

    fun solution(enter: IntArray, leave: IntArray): IntArray {
        val room = mutableListOf<Int>()
        check = Array(enter.size) { IntArray(enter.size) { 0 } }
        val answer = IntArray(enter.size) { 0 }
        var i = 0
        var j = 0

        while (i < enter.size || j < leave.size) {
            val enterNumber =
                if (i < enter.size) enter[i]
                else -1
            if (enterNumber != -1) room.add(enterNumber)
            var leaveNumber = findLeaveNumber(room, leave[j])

            if (leaveNumber != -1) {
                if(enterNumber == leaveNumber) checking(room)
                while (leaveNumber != -1) {
                    room.removeAt(room.indexOf(leaveNumber))
                    j++
                    leaveNumber =
                        if (j < leave.size) findLeaveNumber(room, leave[j])
                        else -1
                }
            } else { checking(room) }

            checking(room)
            i++
        }

        for(x in enter.indices) {
            for(y in enter.indices) {
                answer[x] += check[x][y]
            }
        }
        return answer
    }

    private fun checking(room: MutableList<Int>) {
        for(x in room.indices) {    //만난 사람 체크
            for(y in room.indices) {
                if (x == y) continue
                check[room[x] - 1][room[y] - 1] = 1
            }
        }
    }

    private fun findLeaveNumber(room: MutableList<Int>, leaveNum: Int): Int {
        for (k in room.indices) {
            if (room[k] == leaveNum) {
                return room[k]
            }
        }
        return -1
    }
}

fun main() {
    val enter = intArrayOf(1, 4, 2, 3)
    val leave = intArrayOf(2, 1, 4, 3)

    print(Solution().solution(enter, leave))
}