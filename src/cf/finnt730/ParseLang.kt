package cf.finnt730

import java.util.concurrent.atomic.AtomicInteger


object ParseLang {
    @Synchronized
    @JvmStatic
    fun parse(code: String): Array<KeyWords?> {
        val index = AtomicInteger()
        val words = arrayOfNulls<KeyWords>(10000)
        code.chars().forEach { c: Int ->
            when (c.toChar()) {
                '+' -> {
                    words[index.get()] = KeyWords.ADD
                    index.getAndIncrement()

                }
                '-' -> {
                    words[index.get()] = KeyWords.SUB
                    index.getAndIncrement()

                }
                '<' -> {
                    words[index.get()] = KeyWords.LAST
                    index.getAndIncrement()

                }
                '>' -> {
                    words[index.get()] = KeyWords.NEXT
                    index.getAndIncrement()

                }
                '*' -> {
                    words[index.get()] = KeyWords.MUL
                    index.getAndIncrement()

                }
                '$' -> {
                    words[index.get()] = KeyWords.PRINT
                    index.getAndIncrement()

                }
                else -> {}
            }
        }
        return words
    }
}