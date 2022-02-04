import kotlin.math.min

const val MAX = 1000000001

data class Potion(
    val name: String,
    var minCost: Int = -1,
    var formulas: MutableList<String> = mutableListOf()
)

fun main() {
    val potionList: MutableList<Potion> = mutableListOf()
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    for (i in 0 until n) {
        val input = readLine().toString()
        val potionName = input.substring(0, input.indexOf(' '))
        val potionCost = input.substring(input.indexOf(" ") + 1).toInt()

        val potionIndex = findPotionIndex(potionList, potionName)
        if(potionIndex == -1) potionList.add(Potion(potionName, potionCost))    //기존에 없던 포션일 때는 새로 만들어 저장
        else min(potionList[potionIndex].minCost, potionCost)   //기존에 있던 포션일 때는 더 저렴한 포션을 기록
    }

    for(i in 0 until m) {
        val input = readLine().toString()
        val potionName = input.substring(0, input.indexOf('='))
        val potionFormula = input.substring(input.indexOf("=") + 1)

        var potionIndex = findPotionIndex(potionList, potionName)
        if(potionIndex == -1) { //기존에 없던 포션일 때는 포션을 새로 만들어 저장
            potionList.add(Potion(potionName))
            potionIndex = potionList.lastIndex
        }
        potionList[potionIndex].formulas.add(potionFormula)   //포션의 새로운 식을 추가해줌
    }

    //포션의 식을 계속해서 대입
    for(x in 0 until 50) {
        for(i in 0 until potionList.size) { //첫 포션부터 마지막 포션까지
            for(j in 0 until potionList[i].formulas.size) { //현재 포션을 만들 수 있는 각각의 식들을 이용해 최소 비용을 갱신
                var formula: String = potionList[i].formulas[j]
                var sum = 0

                while (formula != "") { //식에 필요한 재료를 검사하며 sum에 더해둔다
                    val potionInf: String
                    if(formula.contains("+")) {
                        potionInf = formula.substring(0, formula.indexOf("+"))
                        formula = formula.substring(formula.indexOf("+") + 1)
                    }
                    else {  //마지막 재료일 때는 +가 없다
                        potionInf = formula
                        formula = ""
                    }

                    val potionNumber = potionInf.substring(0, 1).toLong()
                    val potionName = potionInf.substring(1)
                    val potionIndex = findPotionIndex(potionList, potionName)
                    if(potionIndex == -1 || potionList[potionIndex].minCost == -1) {
                        sum = -1
                        break
                    }
                    else if (potionList[potionIndex].minCost >= MAX ||
                        (sum + (potionNumber * potionList[potionIndex].minCost)) >= MAX) {
                        sum = MAX
                        break
                    } else {
                        sum += (potionNumber * potionList[potionIndex].minCost).toInt()
                    }
                }

                if(sum != -1) {
                    if(potionList[i].minCost == -1) potionList[i].minCost = sum
                    else potionList[i].minCost = min(sum, potionList[i].minCost)
                }
                else if(sum >= MAX) {
                    potionList[i].minCost = MAX
                }
            }
        }
    }

    val printIndex = findPotionIndex(potionList, "LOVE")
    when (printIndex) {
        -1 -> print(-1)
        MAX -> print(MAX)
        else -> print(potionList[printIndex].minCost)
    }
}

fun findPotionIndex(potionList: List<Potion>, potionName: String): Int {
    var result = -1
    if(potionList.find { it.name == potionName } != null) { //클래스에 찾고자 하는 원소가 있다면
        for(i in potionList.indices) {  //처음부터 끝까지 체크하여 위치를 반환
            if(potionList[i].name == potionName) result = i
        }
    }
    return result
}
