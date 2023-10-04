fun main() {
    val str = readln()
    var best = 0

    for (i in 0 .. str.length) {
        for (j in i - 2 downTo 0 step 2) {
            if (i - j < best) continue
            val str1 = str.substring(j, (i + j) / 2)
            val str2 = str.substring((i + j) / 2, i)
            val str1Sum = str1.toCharArray().sumOf { it.digitToInt(10) }
            val str2Sum = str2.toCharArray().sumOf { it.digitToInt(10) }
            if (str1Sum == str2Sum) best = i - j
        }
    }

    println(best)
}