fun main() {
    val word = readLine()!!.toString()

    print(segmentKorean(word))
}

fun segmentKorean(word: String): MutableList<Char>  {
    //todo 글자를 초성, 중성, 종성으로 나눈다.
    val segmentedKorean: MutableList<Char> = mutableListOf()

    for(i in word.indices) {
        val word2 = word[i].code - 0xAC00
        val onset = word2 / (21 * 28)
        val nucleus = word2 % (21 * 28) / 28
        val coda = word2 % 28

        println("초성: $onset → ${(0x1100 + onset).toChar()}")
        segmentedKorean.add((0x1100 + onset).toChar())
        println("중성: $nucleus → ${(0x1161 + nucleus).toChar()}")
        segmentedKorean.add((0x1161 + nucleus).toChar())
        if(coda > 0) {
            println("종성: $coda → ${(0x11A8 + coda - 1).toChar()}")
            segmentedKorean.add((0x11A8 + coda - 1).toChar())
        }
        println()
        segmentedKorean.add(' ')
    }

    return segmentedKorean
}
