fun main(args: Array<String>) {
    val (n, k) = readln().split(" ").map(String::toInt)
    val arr: IntArray = IntArray(n) { readln().toInt() }
    val checked: Array<BooleanArray> = Array(k + 1) { BooleanArray(k + 1) { false } }

    for (i in 0 until arr.size) {
        if (arr[i] !in 0 .. k) continue
        checked[1][arr[i]] = true
    }
    if (checked[1][k]) {
        print(1)
        return
    }

    for (i in 2 .. k) {
        for (j in 1 .. k) {
            if (!checked[i - 1][j]) continue

            for (arrIndex in 0 until arr.size) {
                if (j + arr[arrIndex] !in 0 .. k) continue
                checked[i][j + arr[arrIndex]] = true

                if (j + arr[arrIndex] == k) {
                    print(i)
                    return
                }
            }
        }
    }

    print(-1)
}