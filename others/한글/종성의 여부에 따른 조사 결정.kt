fun main() {
    val word = readLine()!!.toString()

    //todo 단어의 뒤에 올 조사를 결정함
    println("${decidePostposition(word, "은", "는")} ~~~")
    println()

    println("${decidePostposition("메타몽", "은", "는")} 몽몽메타몽.")
    println("${decidePostposition("피카츄", "은", "는")} 케첩마니아입니다.")
    println()
    println("${decidePostposition("포켓몬 미스터리 던전", "을", "를")} 플레이해주세요. 하늘의 탐험대 재밌어요.")
    println("${decidePostposition("특히 탐험대", "을", "를")} 해주세요. 구조대보다 재밌어요.")
    println()
    println("${decidePostposition("그란돈", "이", "가")} 공격합니다.")
    println("${decidePostposition("가이오가", "이", "가")} 공격합니다.")

}

fun decidePostposition(word: String, existCoda: String, notExistCoda: String): String  {
    val lastChar: Char = word[word.length - 1]

    // 한글의 시작(가)이나 끝(힣) 범위 초과시 오류
    if(lastChar.code < 0xAC00 || lastChar.code > 0xD7A3) {
        return word
    }
    val postposition: String =
        if ((lastChar.code - 0xAC00) % 28 > 0) existCoda
        else notExistCoda

    return word+postposition
}
