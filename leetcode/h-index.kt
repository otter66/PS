fun solution(N: Int): Int {
    var answer = 0

    val binary: String = N.toString(2)
    val gaps: MutableList<String> = binary.split("1").toMutableList()
    gaps.removeAll { it.isEmpty() }

    if (binary[0] != '1' && gaps.isNotEmpty()) gaps.removeAt(0)
    if (binary[binary.lastIndex] != '1' && gaps.isNotEmpty()) gaps.removeAt(gaps.lastIndex)

    gaps.forEach { gap ->
        if (answer < gap.length) answer = gap.length
    }

    return answer
}