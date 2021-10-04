fun main() {
    val k = readLine()!!.toInt()
    for(t in 1 .. k) {
        var s1 = readLine().toString()
        var s2 = readLine().toString()

        s1 = s1.lowercase()
        s2 = s2.lowercase()

        s1 = s1.replace(Regex("""\s+"""), " ")
        s2 = s2.replace(Regex("""\s+"""), " ")

        s1 = s1.replace(Regex("""^\s+"""), "")
        s2 = s2.replace(Regex("""^\s+"""), "")
        s1 = s1.replace(Regex("""\s+$"""), "")
        s2 = s2.replace(Regex("""\s+$"""), "")

        s1 = s1.replace(Regex("""\s*(\(|\{|\[)\s*"""), "(")
        s2 = s2.replace(Regex("""\s*(\(|\{|\[)\s*"""), "(")
        s1 = s1.replace(Regex("""\s*(\)|\}|\])\s*"""), ")")
        s2 = s2.replace(Regex("""\s*(\)|\}|\])\s*"""), ")")

        s1 = s1.replace(Regex("""\s*(\,|\;)\s*"""), ",")
        s2 = s2.replace(Regex("""\s*(\,|\;)\s*"""), ",")

        s1 = s1.replace(Regex("""\s*\.\s*"""), ".")
        s2 = s2.replace(Regex("""\s*\.\s*"""), ".")
        s1 = s1.replace(Regex("""\s*\:\s*"""), ":")
        s2 = s2.replace(Regex("""\s*\:\s*"""), ":")

        if(s1 == s2) println("Data Set $t: equal")
        else println("Data Set $t: not equal")
        println("")
    }
}