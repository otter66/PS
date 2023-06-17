import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val lectureNumber: Int = InputView().readLectureNumber()
    val lectures: List<Lecture> = InputView().readLectures(lectureNumber)

    println(LectureRoom().getMinLectureRoomNumber(lectures))
}

class InputView {
    fun readLectureNumber(): Int = readln().toInt()

    fun readLectures(lectureNumber: Int): List<Lecture> =
        List(lectureNumber) {
            val (startHour: Int, endHour: Int) = readln().split(" ").map(String::toInt)
            Lecture(startHour = startHour, endHour = endHour)
        }
}

class LectureRoom {
    fun getMinLectureRoomNumber(lectures: List<Lecture>): Int {
        val sortedLectures: List<Lecture> = lectures.sortedBy { it.startHour }
        val lectureRoomEndHours: PriorityQueue<Int> = PriorityQueue()

        sortedLectures.forEach { currentLecture ->
            if (lectureRoomEndHours.isEmpty()) {
                lectureRoomEndHours.add(currentLecture.endHour)
                return@forEach
            }

            if (lectureRoomEndHours.peek() <= currentLecture.startHour ) lectureRoomEndHours.poll()
            lectureRoomEndHours.add(currentLecture.endHour)
        }

        return lectureRoomEndHours.size
    }
}

data class Lecture(
    val startHour: Int,
    val endHour: Int
)