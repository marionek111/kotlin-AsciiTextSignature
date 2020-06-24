package signature

class Board(val border: Char) {
    private val list = MutableList<Any>(0) {}
    var width = 0
        private set

    fun add(string: String) {
        list.add(string)
        if (string.length > width) {
            width = string.length
        }
    }

    fun add(bigString: BigString) {
        list.add(bigString)
        if (bigString.length > width) {
            width = bigString.length
        }
    }

    fun show() {
        println(border.toString().repeat(width + 8))
        for (item in list) {
            when (item) {
                is String -> show(item)
                is BigString -> show(item)
            }
        }
        println(border.toString().repeat(width + 8))
    }

    private fun show(bigString: BigString) {
        val size = width - bigString.length
        val space = " ".repeat(size / 2)
        val refill = if (size % 2 == 1) " " else ""
        println(bigString.get("$border$border  $space", "$space$refill  $border$border"))
    }

    private fun show(string: String) {
        val size = width - string.length
        val space = " ".repeat(size / 2)
        val refill = if (size % 2 == 1) " " else ""
        println("$border$border  $space$string$space$refill  $border$border")
    }
}
