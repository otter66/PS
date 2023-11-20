fun solution(A: IntArray, K: Int): IntArray {
    if (K == 0 || A.size == 0) return A

    val rotationCount: Int = K % A.size
    val rotateNumbers: MutableList<Int> = mutableListOf()
    A.forEach { rotateNumbers.add(it) }

    for(i in 0 until rotationCount) {
        val removed: Int = rotateNumbers.removeAt(rotateNumbers.lastIndex)
        rotateNumbers.add(0, removed)
    }

    return rotateNumbers.toList().toIntArray()
}