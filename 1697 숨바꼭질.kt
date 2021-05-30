//import java.util.*
//
//fun main() {
//    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
//
//    print(bfs(n, k))
//}
//
//fun bfs(n: Int, k: Int): Int {
//    val range: Int = 300000
//    val check = Array<Boolean>(range) {false}
//    val count = Array<Int>(range) {0}
//    check[n] = true
//    val q = LinkedList<Int>()
//    q.add(n)
//
//    while (!q.isEmpty()) {
//        val now = q.remove()
//
//        if(now-1 >= 0) {
//            if (!check[now-1]) {
//                q.add(now-1);
//                check[now-1] = true;
//                count[now-1] = count[now] + 1;
//            }
//        }
//        if (now+1 < range) {
//            if (!check[now+1]) {
//                q.add(now+1);
//                check[now+1] = true;
//                count[now+1] = count[now] + 1;
//            }
//        }
//
//        if (now*2 < range) {
//            if (!check[now*2]) {
//                q.add(now*2);
//                check[now*2] = true;
//                count[now*2] = count[now] + 1;
//            }
//        }
//    }
//
//    return count[k]
//
//}