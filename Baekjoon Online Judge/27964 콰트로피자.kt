fun main() {
    val n: Int = readln().toInt()
    var arr: List<String> = readln().split(" ").toMutableList()
    arr = arr.filter {
        6 <= it.length && it.substring(it.length - 6, it.length) == "Cheese"
    }
    arr = arr.distinct()

    if (4 <= arr.size) println("yummy")
    else println("sad")
}