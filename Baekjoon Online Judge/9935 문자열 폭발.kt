fun main() {
    val str = readLine()!!
    val bomb = readLine()!!
    val stack = mutableListOf<Char>()
    val lastChar = bomb[bomb.lastIndex]

    for(i in str.indices) {
        stack.add(str[i])

        if(stack.size < bomb.length || str[i] != lastChar) continue
        if(stack.subList(stack.size - bomb.length, stack.size).joinToString("") == bomb){
            for(j in bomb.indices)
                stack.removeAt(stack.lastIndex)
        }
    }

    if(stack.isNullOrEmpty())
        print("FRULA")
    else
        print(stack.joinToString(""))
}
