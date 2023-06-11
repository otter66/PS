fun main() {
    val metingNumber: Int = InputView().readMetingNumber()
    val meetings: List<Meeting> = InputView().readMeetings(metingNumber)

    println(MeetingRoom().getMaxMeetingAvailableNumber(meetings))
}

class InputView {
    fun readMetingNumber(): Int = readln().toInt()

    fun readMeetings(metingNumber: Int): List<Meeting> {
        return MutableList(metingNumber) {
            val (startHour: Int, endHour: Int) = readln().split(" ").map(String::toInt)
            Meeting(startHour = startHour, endHour = endHour)
        }
    }
}

class MeetingRoom {
    fun getMaxMeetingAvailableNumber(meetings: List<Meeting>): Int {
        val sortedMeeting: List<Meeting> = meetings.sortedWith(compareBy({ it.endHour }, { it.startHour }))
        var lastMeetingEndHour = 0
        var count = 0

        sortedMeeting.forEach { meeting ->
            if (meeting.startHour < lastMeetingEndHour) return@forEach
            count++
            lastMeetingEndHour = meeting.endHour
        }

        return count
    }
}

data class Meeting(
    val startHour: Int,
    val endHour: Int
)