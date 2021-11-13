import java.math.BigInteger

fun main() {
    val n = readLine()!!.toInt()
    val fibonacci: MutableList<BigInteger> = mutableListOf(BigInteger("0"), BigInteger("1"))

    for(i in 2..n) {
        fibonacci.add(fibonacci[i-1] + fibonacci[i-2])
    }

    print(fibonacci[n])
}