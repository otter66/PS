fun main() {
    println(Solution().gcdOfStrings("ABCABC", "ABC"))
    println(Solution().gcdOfStrings("ABABAB", "ABAB"))
    println(Solution().gcdOfStrings("LEET", "CODE"))
}

class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {

        val len =
            if (str2.length <= str1.length) gcd(str1.length, str2.length)
            else gcd(str2.length, str1.length)

        if (str1 + str2 != str2 + str1) return ""
        return str2.substring(0, len)
    }

    private fun gcd(a: Int, b: Int): Int =
        if (b == 0) a else gcd(b, a % b)
}