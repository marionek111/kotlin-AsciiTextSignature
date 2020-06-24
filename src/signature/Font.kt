package signature

import java.io.File
import java.util.*
import kotlin.collections.HashMap

class Font(file: File, spaceWidth: Int) {
    private val letters: Map<Char, String>
    val letterHeight: Int
    private val supportLowercase: Boolean

    init {
        val scanner = Scanner(file)
        var supportLowercase = false
        letterHeight = scanner.nextInt()
        val count = scanner.nextInt()
        letters = HashMap(count + 1)
        repeat(count) {
            val letterChar = scanner.next().first()
            supportLowercase = supportLowercase || letterChar.isLowerCase()
            val width = scanner.nextInt()
            scanner.nextLine()
            var letter = ""
            repeat(letterHeight) {
                letter += scanner.nextLine() + '\n'
            }
            letters[letterChar] = letter.dropLast(1)
        }
        letters[' '] = initSpace(spaceWidth)
        this.supportLowercase = supportLowercase
    }

    fun letter(char: Char) = letters[if (supportLowercase) char else char.toUpperCase()]

    private fun initSpace(spaceWidth: Int): String {
        return " ".repeat(spaceWidth).plus("\n").repeat(letterHeight).dropLast(1)
    }
}