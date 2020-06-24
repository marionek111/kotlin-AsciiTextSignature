package signature

class BigString(string: String, private val font: Font) {
    val length: Int
        get() = lines.first().length
    private val lines = Array(font.letterHeight) { "" }

    init {
        iniString(string)
    }

    fun get(prefix: String = "", suffix: String = "") = lines.joinToString("\n") { "$prefix$it$suffix" }

    override fun toString() = get()

    private fun iniString(string: String) {
        string.forEach { addLetter(it) }
    }

    private fun addLetter(char: Char) {
        val letter = font.letter(char)
        if (letter != null) {
            val linerLines = letter.split('\n').toTypedArray()
            for (i in lines.indices) {
                lines[i] += linerLines[i]
            }
        }
    }
}
