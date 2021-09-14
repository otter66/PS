import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    val dpLeft = IntArray(n)
    val dpRight = IntArray(n)

    for (i in 0 until n) {
        dpLeft[i] = numbers[i]
        if (i == 0) continue
        if (dpLeft[i] < dpLeft[i - 1] + dpLeft[i]) {
            dpLeft[i] = dpLeft[i - 1] + dpLeft[i]
        }
    }

    for (i in n - 1 downTo 0) {
        dpRight[i] = numbers[i]
        if (i == n - 1) continue
        if (dpRight[i] < dpRight[i] + dpRight[i + 1]) {
            dpRight[i] = dpRight[i] + dpRight[i + 1]
        }
    }

    var max1 = -100000001
    for (i in 0 until n) {
        if (dpLeft[i] > max1) max1 = dpLeft[i]
    }
    var max2 = dpLeft[0]
    for (i in 1 until n) {
        if (i == n - 1) {
            if (dpLeft[i - 1] > max2) max2 = dpLeft[i - 1]
            continue
        }
        if (dpLeft[i - 1] + dpRight[i + 1] > max2) {
            max2 = dpLeft[i - 1] + dpRight[i + 1]
        }
    }

    print(max(max1, max2))
}