fun main() {
    Solution().solution(arrayOf(
        arrayOf("crow_mask", "face"),
        arrayOf("blue_sunglasses", "face"),
        arrayOf("smoky_makeup", "face")
    ))
}

class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val types: MutableMap<String, Int> = mutableMapOf()

        for (i in 0 until clothes.size) {
            val clothesType = clothes[i][1]
            if (types.containsKey(clothesType).not()) types[clothesType] = 1
            else types[clothesType] = types.getValue(clothesType) + 1
        }

        types.forEach {
            answer *= (it.value + 1)
        }

        return answer - 1
    }
}