fun main() {
    val (r1, s) = readLine()!!.split(" ").map { it.toInt() }
    print(2 * s - r1)
}