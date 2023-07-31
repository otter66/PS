fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val numbers: Array<Int> = Array(n + 1) { 0 }
    for (i in 1 .. n) numbers[i] = readln().toInt()
    val dp: Array<Int> = Array(k + 1) { 0 }
    dp[0] = 1

    for (nIndex in 1..n) {
        for (kIndex in numbers[nIndex] .. k) {
            dp[kIndex] += dp[kIndex - numbers[nIndex]]
        }
    }

    println(dp[k])
}

/*
    총 소요시간: 대략 두시간 정도 소요된 것 같다.
    블로그의 풀이를 참고햐여 풀었다.
    https://velog.io/@jxlhe46/%EB%B0%B1%EC%A4%80-2293%EB%B2%88.-%EB%8F%99%EC%A0%84-1-bfi120m5
    규칙을 찾기가 어려웠다.
    각각의 경우에 대해서만 나열해보고 규칙을 찾으려고 했던 것 같다.
    조금 더 모든 경우를 나열해보고 조합해보며 느긋하게 풀 수 있도록 노력해야겠다.

    풀이 손그림 이미지 : ./images/img_2293_동전_1.jpeg
 */