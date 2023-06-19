fun main() {
    val str = readln()
    println(StringFormula(str).calculateOptimal())
}

class StringFormula(
    private val str: String
) {
    fun calculateOptimal(): Int {
        var remainCalcFormula = str
        var sum = 0
        var minusFlag = false

        while (remainCalcFormula.isNotBlank()) {
            val num: Int
            val separatorIndex: Int
            var separator = '+'

            if (findSeparator(remainCalcFormula) != null) {
                separatorIndex = findSeparatorIndex(remainCalcFormula)
                separator = remainCalcFormula[separatorIndex]
                num = remainCalcFormula.substringBefore(separator).toInt()
                remainCalcFormula = remainCalcFormula.substringAfter(separator)
            } else {
                num = remainCalcFormula.toInt()
                remainCalcFormula = ""
            }

            if (minusFlag) sum -= num
            else sum += num

            if (separator == '-') minusFlag = true
        }

        return sum
    }

    private fun findSeparator(str: String): Char? = str.find { it == '+' || it == '-' }

    private fun findSeparatorIndex(str: String): Int = str.indexOfFirst { it == '+' || it == '-' }
}