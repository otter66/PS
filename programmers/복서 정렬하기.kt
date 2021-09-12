class Solution {
    inner class BoxerPlayer(
        val winRate: Float,
        val winHeavierBoxer: Int,
        val weight: Int,
        val firstGivenNumber: Int
    )

    fun solution(weights: IntArray, head2head: Array<String>): IntArray {
        val answer: IntArray = IntArray(weights.size) { 0 }
        val boxerList: MutableList<BoxerPlayer> = mutableListOf()

        for (i in weights.indices) {
            var myWinRate = 0.0f
            var myWinHeavierBoxer = 0

            var winCount = 0
            var WLCount = head2head[i].length
            for (j in head2head[i].indices) {
                if (head2head[i][j] == 'W') {
                    winCount++
                    if (weights[i] < weights[j]) {
                        myWinHeavierBoxer++
                    }
                } else if(head2head[i][j] == 'N') {
                    WLCount --
                }
            }
            if (winCount > 0) myWinRate = winCount.toFloat() / WLCount

            boxerList.add(
                BoxerPlayer(
                    myWinRate,
                    myWinHeavierBoxer,
                    weights[i],
                    i
                )
            )
        }

        //todo?? //boxerList.sortWith(compareBy({ it.winRate }, { it.winHeavierBoxer }, { it.weight }, { boxerList.size - it.firstGivenNumber }))
        for(i in 0 until boxerList.size) {
            for (j in i + 1 until boxerList.size) {
                if (boxerList[i].winRate < boxerList[j].winRate) {
                    boxerList.swap(i, j)
                } else if (boxerList[i].winRate == boxerList[j].winRate) {
                    if (boxerList[i].winHeavierBoxer < boxerList[j].winHeavierBoxer) {
                        boxerList.swap(i, j)
                    } else if (boxerList[i].winHeavierBoxer == boxerList[j].winHeavierBoxer) {
                        if(boxerList[i].weight < boxerList[j].weight) {
                            boxerList.swap(i, j)
                        } else if(boxerList[i].weight == boxerList[j].weight) {
                            if(boxerList[i].firstGivenNumber > boxerList[j].firstGivenNumber) {
                                boxerList.swap(i, j)
                            }
                        }
                    }
                }
            }
        }

        for (i in boxerList.indices) {
            answer[i] = boxerList[i].firstGivenNumber + 1
        }
        return answer
    }

    private fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
        val tmp = this[index1]
        this[index1] = this[index2]
        this[index2] = tmp
    }
}

fun main() {
    //todo testCase 3
//    val weights = intArrayOf(60,70,60)
//    val head2head = arrayOf<String>("NNN","NNN","NNN")

    //todo testCase 2
    val weights = intArrayOf(145,92,86)
    val head2head = arrayOf("NLW","WNL","LWN")


    Solution().solution(weights, head2head)

}