import kotlin.math.min


fun main () {
    val (x: String, y: String) = readLine()!!.split(" ")
    var min = 51

    for (i in 0 .. y.length - x.length) {
        min = min(checking(x, y.substring(i, i + x.length)), min)
    }

    print(min)
}

fun checking(x: String, y: String): Int {
    var cnt = 0
    for(i in x.indices) {
        if(x[i] != y[i]) cnt ++
    }
    return cnt
}