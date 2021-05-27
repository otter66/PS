import java.util.*

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }

    val route : MutableList<Int> = bfs(n, k)

    println(route.size-1)
    for(i in 0 until route.size) {
        print("${route[i]} ")
    }
}

fun bfs(n: Int, k: Int): MutableList<Int> {
    val range = 200000
    val count = Array(range+1) { IntArray(2) {-1} }
    val q = LinkedList<Int>()


    q.add(n)
    count[n][0] = 0

    while (!q.isEmpty()) {
        val now = q.remove()

        if(now-1 >= 0 && count[now-1][0] == -1) {
            count[now-1][1] = now

            count[now-1][0] = count[now][0] + 1
            q.add(now-1)
        }
        if(now+1 <= range && count[now+1][0] == -1) {
            count[now+1][1] = now

            count[now+1][0] = count[now][0] + 1
            q.add(now+1)
        }
        if(now*2 <= range && count[now*2][0] == -1) {
            count[now*2][1] = now

            count[now*2][0] = count[now][0] + 1
            q.add(now*2)
        }

        if(count[k][0] != -1) break
    }

    val route = MutableList<Int>(0) {0}
    var now = k
    while (count[now][1] != -1) {
        route.add(count[now][1])
        now = count[now][1]
    }

    route.reverse()
    route.add(k)
    return route
}
