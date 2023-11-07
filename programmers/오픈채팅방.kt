class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = arrayOf<String>()
        val enter: MutableList<Pair<String, String>> = mutableListOf()
        val user: MutableMap<String, String> = mutableMapOf()

        for (i in 0 until record.size) {
            val r = record[i]
            val str: List<String> = r.split(" ")
            if (str[0] == "Change" || str[0] == "Enter") user[str[1]] = str[2]
            if (str[0] == "Enter" || str[0] == "Leave") enter.add(Pair(str[0], str[1]))
        }

        for (i in 0 until enter.size) {
            val userName: String = user[enter[i].second] ?: ""
            val a: String =
                if (enter[i].first == "Enter") "${userName}님이 들어왔습니다."
                else "${userName}님이 나갔습니다."
            answer += a
        }

        return answer
    }
}