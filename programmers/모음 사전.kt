class Solution {
    fun solution(word: String): Int {
        var answer = 0
        val dicNum: MutableList<Int> = mutableListOf(1)
        //todo  A:1  E:2  I:3  O:4  U:5

        var i = 1
        while (true) {
            if (dicNum == mutableListOf(5, 5, 5, 5, 5)) break
            else if (wordization(dicNum) == word) break
            else if (i >= 3200) break

            else if (dicNum.size < 5) dicNum.add(1)
            else if (dicNum[dicNum.lastIndex] >= 5) {
                while (dicNum[dicNum.lastIndex] >= 5) {
                    dicNum.removeAt(dicNum.lastIndex)
                }
                dicNum[dicNum.lastIndex]++
            }
            else if (dicNum[dicNum.lastIndex] < 5) {
                dicNum[dicNum.lastIndex]++
            }
            i++
        }

        answer = i
        return answer
    }

    private fun wordization(dicNum: MutableList<Int>): String {
        var wordOfNumber = ""
        for(k in 0 until dicNum.size) {
            wordOfNumber +=
                when (dicNum[k]) {
                    1 -> 'A'
                    2 -> 'E'
                    3 -> 'I'
                    4 -> 'O'
                    else -> 'U'
                }
        }
        return wordOfNumber
    }
}

fun main() {
    Solution().solution("AAAAA")
}

