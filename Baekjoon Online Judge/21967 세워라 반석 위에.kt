import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val (pointNumber, relationNumber, searchPoint) = readln().split(" ").map(String::toInt)
    val relations: Array<ArrayList<Int>> = readRelations(pointNumber, relationNumber)

    val visited = Array(pointNumber + 1) { false }
    searchDFS(relations = relations, visited = visited, searchPoint = searchPoint)
    println()

    visited.fill(false)
    searchBFS(relations = relations, visited = visited, searchPoint = searchPoint)
}

fun readRelations(n: Int, relationNumber: Int): Array<ArrayList<Int>> {
    val relations: Array<ArrayList<Int>> = Array(n + 1) { arrayListOf() }

    repeat(relationNumber) {
        val (a, b) = readln().split(" ").map(String::toInt)
        relations[a].add(b)
        relations[b].add(a)
    }

    relations.map { it.sort() }
    return relations
}

fun searchDFS(relations: Array<ArrayList<Int>>, visited: Array<Boolean>, searchPoint: Int) {
    visited[searchPoint] = true
    print("$searchPoint ")

    relations[searchPoint].forEach { nextSearchPoint ->
        if (visited[nextSearchPoint]) return@forEach

        searchDFS(relations, visited, nextSearchPoint)
    }
}

fun searchBFS(relations: Array<ArrayList<Int>>, visited: Array<Boolean>, searchPoint: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.add(searchPoint)
    visited[searchPoint] = true

    while (queue.isNotEmpty()) {
        val currentSearchPoint: Int = queue.remove()
        print("$currentSearchPoint ")

        relations[currentSearchPoint].forEach { nextSearchPoint ->
            if (visited[nextSearchPoint]) return@forEach

            queue.add(nextSearchPoint)
            visited[nextSearchPoint] = true
        }
    }
}