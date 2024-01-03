val opcode: Map<String, String> = mapOf(
    Pair("ADD", "00000"), Pair("ADDC", "00001"),
    Pair("SUB", "00010"), Pair("SUBC", "00011"),
    Pair("MOV", "00100"), Pair("MOVC", "00101"),
    Pair("AND", "00110"), Pair("ANDC", "00111"),
    Pair("OR",  "01000"), Pair("ORC",  "01001"),
    Pair("NOT", "01010"),
    Pair("MULT", "01100"), Pair("MULTC", "01101"),
    Pair("LSFTL", "01110"), Pair("LSFTLC", "01111"),
    Pair("LSFTR", "10000"), Pair("LSFTRC", "10001"),
    Pair("ASFTR", "10010"), Pair("ASFTRC", "10011"),
    Pair("RL", "10100"), Pair("RLC", "10101"),
    Pair("RR", "10110"), Pair("RRC", "10111"),
)

fun main() {
    val n: Int = readln().toInt()

    for (i in 0 until n) {
        val (inputOpcode, rD, rA, rBorrC) = readln().split(" ")
        var result: String = ""

        result += opcode[inputOpcode]
        result += "0"
        result += getBinaryNumber(rD, 3)
        result += getBinaryNumber(rA, 3)
        if (result[4] == '0') {
            result += getBinaryNumber(rBorrC, 3)
            result += "0"
        }
        else {
            result += getBinaryNumber(rBorrC, 4)
        }

        println(result)
    }

}

fun getBinaryNumber(str: String, digitNumberUnit: Int): String {
    var result = ""
    val binaryStr: String = str.toInt().toString(2)

    for (i in 0 until digitNumberUnit) {
        if (i + binaryStr.length == digitNumberUnit) break
        result += "0"
    }

    return result + binaryStr
}