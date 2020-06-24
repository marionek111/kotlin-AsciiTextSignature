package signature

import java.io.File

fun main() {
    print("Enter name and surname: ")
    val name = readLine()!!
    print("Enter person's status: ")
    val status = readLine()!!

    val fontsDir = "C:/fonts"
    val fontRoman = Font(File("$fontsDir/roman.txt"), 10)
    val fontMedium = Font(File("$fontsDir/medium.txt"), 5)

    val board = Board('8')
    board.add(BigString(name, fontRoman))
    board.add(BigString(status, fontMedium))
    board.show()
}
