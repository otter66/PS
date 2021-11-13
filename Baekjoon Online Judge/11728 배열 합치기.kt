import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

//code 1
fun main () {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine()!!.split(" ").map { it.toInt() }
    val a = br.readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val b = br.readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    var aIndex = 0
    var bIndex = 0
    a.sort()
    b.sort()

    while (aIndex < n || bIndex < m) {
        if(aIndex >= n) {
            bw.write("${b[bIndex]} ")
            bIndex++
            continue
        }
        if(bIndex >= m) {
            bw.write("${a[aIndex]} ")
            aIndex++
            continue
        }

        if(a[aIndex] <= b[bIndex]) {
            bw.write("${a[aIndex]} ")
            aIndex++
        }
        else if(a[aIndex] > b[bIndex]) {
            bw.write("${b[bIndex]} ")
            bIndex++
        }
    }

    bw.close()
}


//code 2
//fun main () {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val bw = BufferedWriter(OutputStreamWriter(System.out))
//
//    val (n, m) = br.readLine()!!.split(" ").map { it.toInt() }
//    val a = br.readLine()!!.split(" ").map { it.toInt() }.toIntArray()
//    val b = br.readLine()!!.split(" ").map { it.toInt() }.toIntArray()
//    val list = ArrayList<Int>()
//
//    for(i in 0 until n) {
//        list.add(a[i])
//    }
//    for(j in 0 until m) {
//        list.add(b[j])
//    }
//
//    list.sorted().forEach {
//        bw.write("$it ")
//    }
//    bw.close()
//}