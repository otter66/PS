fun main () {
    var t = readLine()!!.toInt()

    while (t-->0) {
        val (h, w, n) = readLine()!!.split(" ").map { it.toInt() }
        val y = if(n % h == 0) h else n % h
        val x = if(n % h == 0) n / h else n / h + 1

        if(x < 10)
            println("${y}0${x}")
        else
            println("${y}${x}")
    }
}