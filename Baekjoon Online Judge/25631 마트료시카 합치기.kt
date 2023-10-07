fun main() {
    val n = readln().toInt()
    val arr: MutableList<Int> = readln().split(" ").map { it.toInt() }.sorted().toMutableList()
    var answer = 0

    while (0 < arr.size) {
        var currentSize = -1
        var i = 0
        while (i < arr.size) {
            if (currentSize < arr[i]) {
                currentSize = arr[i]
                arr.removeAt(i)
            } else i++
        }
        answer++
    }

    println(answer)
}