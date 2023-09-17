fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toMutableList()
    var count = 0

    while (0 < arr.sum()) {
        arr.removeIf { it == 0 }
        if (arr.size == 1) {
            arr[0]--
            count++
        } else {
            arr.sortDescending()
            arr[0]--
            arr[1]--
            count++
        }
    }

    if (count.toFloat() / 60 <= 24) {
        println(count)
    } else {
        println(-1)
    }

}

/*
15분 소요.
어떻게 가장 큰 수의 위치, 두번째로 가장 큰 수의 위치를 찾을 건인지 조금 고민했다. 정렬을 하면 된다는 것을 빨리 생각해냈던게 다행이다.
 */