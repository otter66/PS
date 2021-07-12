fun main() {
    var t : Int = readLine()!!.toInt()

    while(t > 0) {
        var answer : Long = 0
        val numbers = readLine()!!.split(" ").toMutableList()
        numbers.removeAt(0)

        for(i in 0 until numbers.size) {
            for(j in i+1 until numbers.size) {
                answer += gcd(numbers[i].toInt(), numbers[j].toInt())
            }
        }

        println(answer)
        t--
    }
}

fun gcd(a1: Int, b1: Int): Int {
    var a = a1
    var b = b1

    while (b != 0) {
        val r = a%b
        a = b
        b = r
    }
    return a
}