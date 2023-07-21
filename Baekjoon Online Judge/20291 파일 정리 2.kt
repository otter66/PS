import java.util.TreeMap

fun main() {
    val n: Int = readln().toInt()
    val map: TreeMap<String, Int> = TreeMap()
    repeat(n) {
        val extension = readln().substringAfter('.')
        map[extension] = map.getOrDefault(extension, 0) + 1
    }
    map.toList().sortedBy { it.first }.forEach { println("${it.first} ${it.second}") }
}

/*
    총 소요시간: 1시간 정도.
    처음 제출하는데는 30분도 걸리지 않았지만, 시간초과로인해 탐색하는 시간이 추가로 30분 정도 소요되었다.
    백준에 제출된 코드를 보며 map을 활용한 방법, groupBy를 활용한 방법을 찾을 수 있었다.
    SortedMap, treeMap이라는 것을 처음 알았다.
 */