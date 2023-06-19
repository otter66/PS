fun main() {
    val str = readln()
    println(StringFormula(str).calculateOptimal())
}

class StringFormula(
    private val str: String
) {
    fun calculateOptimal(): Int {
        if (str.isNotContainMinusSeparator()) return str.sumAllNumbers()

        val sumPositiveNumbers = str.substringBefore('-').sumAllNumbers()
        val sumNegativeNumbers = str.substringAfter('-').sumAllNumbers()

        return sumPositiveNumbers - sumNegativeNumbers
    }

    private fun String.isNotContainMinusSeparator(): Boolean = !contains('-')

    private fun String.sumAllNumbers(): Int = split('+', '-').sumOf { it.toInt() }
}
