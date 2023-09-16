fun main() {
    val n = readln().toInt()
    val arr = List(15) { MutableList(15) { it } }

    arr.forEachIndexed { rowIndex, row ->
        if (rowIndex == 0) return@forEachIndexed
        row.forEachIndexed { colIndex, number ->
            val sum = arr[rowIndex - 1].subList(0, colIndex + 1).sum()
            arr[rowIndex][colIndex] = sum
        }
    }

    repeat(n) {
        val a = readln().toInt()
        val b = readln().toInt()
        println(arr[a][b])
    }
}

/*
16분 소요.
문제를 이해하는데 조금 시간이 걸렸다.
 */