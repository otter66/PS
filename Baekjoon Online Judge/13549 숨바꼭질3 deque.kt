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
//    val deque = ArrayDeque<Int>()
//
//    deque.addFirst(n)
//    count[n] = 0
//
//    while (!deque.isEmpty()) {
//        val now = deque.removeFirst()
//
//        if(now*2 <= range && count[now*2] == -1) {
//            deque.addFirst(now*2)
//            count[now*2] = count[now]
//        }
//        if(now+1 <= range && count[now+1] == -1) {
//            deque.addLast(now+1)
//            count[now+1] = count[now] + 1
//        }
//        if(now-1 >= 0 && count[now-1] == -1) {
//            deque.addLast(now-1)
//            count[now-1] = count[now] + 1
//        }
//    }
//
//    return count[k]
//
//}