fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val arr = MutableList(n) { it }


    repeat(m) {
        val (x, y) = readln().split(" ").map { it.toInt() - 1 }

        val lastNumber = arr[y]
        for (i in x..y) {
            arr[i] = arr[x]
        }
        for (i in y + 1 until arr.size) {
            if (arr[i] == lastNumber) arr[i] = arr[y]
        }
    }

    println(arr.distinct().size)
}

/*
20분 소요.
처음에 해당 케이스를 생각하지 않았다. https://www.acmicpc.net/board/view/79827
8
6
5 8
6 7
4 7
5 6
1 3
1 5

1

틀린 직후 위와 같은 느낌의 반례일 것이라 생각했지만, 직접 찾기는 귀찮아 질문 게시판을 봤다.
다음부터는 질문 게시판을 보지 않고 직접 반례 케이스를 찾도록!
 */