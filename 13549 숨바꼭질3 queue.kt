//import java.util.*
//
//fun main() {
//    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
//
//    print(bfs(n, k))
//}
//
//fun bfs(n: Int, k: Int): Int {
//    val range = 300000
//    val count = Array<Int>(range+1) {-1}
//    var q = LinkedList<Int>()
//    var nextQ = LinkedList<Int>()
//
//    q.add(n)
//    count[n] = 0
//
//    while(!q.isEmpty()) {
//        val now = q.remove()
//
//        if(now*2 <= range && count[now*2] == -1) {
//            q.add(now*2)
//            count[now*2] = count[now]
//        }
//        if(now-1 >= 0 && count[now-1] == -1) {
//            nextQ.add(now-1)
//            count[now-1] = count[now] + 1
//        }
//        if(now+1 <= range && count[now+1] == -1) {
//            nextQ.add(now+1)
//            count[now+1] = count[now] + 1
//        }
//
//        if(q.isEmpty()) {
//            q = nextQ
//            nextQ = LinkedList<Int>()
//        }
//    }
//
//    return count[k]
//}