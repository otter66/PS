//fun main() {
//    var t = readLine()!!.toInt()
//
//    while (t > 0) {
//        t--
//        var a: Long = 1
//        var b: Long = 2
//        var c: Long = 4
//        var result: Long = 0
//        val n = readLine()!!.toInt()
//
//        if(n == 1) result = 1
//        if(n == 2) result = 2
//        if(n == 3) result = 4
//        for(i in 4..n) {
//            result = (a + b + c) % 1000000009L
//            a = b
//            b = c
//            c = result
//        }
//
//        println(result)
//    }
//}