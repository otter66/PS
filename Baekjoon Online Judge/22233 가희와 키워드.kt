import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val hm = hashSetOf<String>().apply {
        repeat(n) { this.add(br.readLine()) }
    }

    repeat(m) {
        val blogPostKeywords = br.readLine().split(',').toTypedArray()
        blogPostKeywords.forEach { hm.remove(it) }
        sb.append(hm.size).append('\n')
    }
    println(sb.toString())
}