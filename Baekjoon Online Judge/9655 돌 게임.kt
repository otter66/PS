fun main() {
    val n: Int = readln().toInt()
    var last: Int = if (n % 6 == 0) 6 else n % 6
    var currentPlayer: Player = Player.SANG_KUN

    while (0 < last) {
        if (3 <= last)  {
            currentPlayer = currentPlayer.nextPlayer()
            last -= 3
        }
        else {
            currentPlayer = currentPlayer.nextPlayer()
            last -= 1
        }
    }

    val winnerPlayer: Player = currentPlayer.previousPlayer()

    println(winnerPlayer.initialName)
}

enum class Player(val initialName: String) {
    SANG_KUN("SK"),
    CHANG_YOUNG("CY");

    fun nextPlayer(): Player {
        return when (this) {
            CHANG_YOUNG -> SANG_KUN
            SANG_KUN -> CHANG_YOUNG
        }
    }

    fun previousPlayer(): Player {
        return when (this) {
            CHANG_YOUNG -> SANG_KUN
            SANG_KUN -> CHANG_YOUNG
        }
    }
}