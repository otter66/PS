import java.lang.StringBuilder
import kotlin.text.Typography.tm

fun main() {
    val recording: StringBuilder = StringBuilder(readln())
    val sound: String = "quack"
    val ducks: MutableList<StringBuilder> = mutableListOf()

    ducks.add(StringBuilder(recording[0].toString()))
    recording.deleteAt(0)

    while (recording.isNotEmpty()) {
        val tmp: Char = recording[0]
        recording.deleteAt(0)

        // 울음소리의 시작 글자일 때
        if (tmp == sound[0]) {
            // 기존의 오리가 추가로 울었다면 오리의 울음소리를 늘려준다.
            if (ducks.find { it[it.lastIndex] == sound[sound.lastIndex] } != null) {
                val duckIndex: Int = ducks.indexOfFirst { it[it.lastIndex] == sound[sound.lastIndex] }
                ducks[duckIndex].append(tmp)
            }
            // 새로운 오리라면 오리를 추가한다.
            else {
                ducks.add(StringBuilder(tmp.toString()))
            }
            continue
        }

        // 정상적인 녹음이 아니라면(울음소리가 연결되지 않으면) 결과를 출력하고 프로그램을 종료한다.
        val tmpSoundIndex: Int = sound.indexOf(tmp)
        if (ducks.find { it[it.lastIndex] == sound[tmpSoundIndex - 1] } == null) {
            println("-1")
            return
        }

        // 오리의 울음소리를 찾아 매칭시켜준다.
        val duckIndex: Int = ducks.indexOfFirst { it[it.lastIndex] == sound[tmpSoundIndex - 1] }
        ducks[duckIndex].append(tmp)
    }

    // 울음소리가 이어지지 못한다면 -1을 출력한다.
    if (ducks.find { it[it.lastIndex] != sound[sound.lastIndex] } != null ) println(-1)
    // 오리의 수를 세어 출력한다.
    else println(ducks.size)
}

/*
    약 1시간 30분 소요.
 */