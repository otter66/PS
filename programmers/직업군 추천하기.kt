import kotlin.math.max

data class ProfessionalAptitude(
    var jobName: String,
    var aptitude: Int
)

class Solution {
    fun solution(table: Array<String>, languages: Array<String>, preference: IntArray): String {
        val total: Array<ProfessionalAptitude> = Array(table.size) { ProfessionalAptitude("", 0) }
        var answer: String = ""

        var max = -1
        for (k in table.indices) {
            val jobLanguage = table[k].split(" ")
            total[k].jobName = jobLanguage[0]
            for(i in 1 until jobLanguage.size) {
                for(j in languages.indices) {
                    if(jobLanguage[i] == languages[j]) {
                        total[k].aptitude += (6 - i) * preference[j]
                    }
                }
            }
            max = max(max, total[k].aptitude)
        }

        val tmp = mutableListOf<String>()
        for(i in total.indices) {
            if(max == total[i].aptitude) tmp.add(total[i].jobName)
        }
        tmp.sort()

        answer = tmp[0]
        return answer
    }
}