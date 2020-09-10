package io.github.sekreto

import java.io.File

const val FILE_OUTPUT = "sekreto.txt"
private const val WORD_LIST_SIZE = 2048
private const val CODE_LENGTH = 4
private const val RANGE_END = 9999
private const val HEADER_CODE = "Code"
private const val HEADER_WORD = "Mapped Word"

/**
 * Generates a Map<Sting, String> containing a randomized code for each word mapped.
 * The generated code should have the format 0042, padding zeros on the left until reach the configured length.
 */
fun generateCodeTable(words: List<String>): Map<String, String> {
    val table = LinkedHashMap<String, String>(2049)
    table[HEADER_CODE.padEnd(CODE_LENGTH, ' ')] = HEADER_WORD

    (0..RANGE_END)
        .shuffled()
        .shuffled()
        .take(WORD_LIST_SIZE)
        .mapIndexed { index, value ->
            val item = value.toString()
            val code = when (item.length < CODE_LENGTH) {
                true -> item.padStart(CODE_LENGTH, '0')
                false -> item
            }
            table[code] = words[index]
        }

    return table.toMap()
}

/**
 * Write a file object containing the final formatted content
 */
fun prepareOutput(table: Map<String, String>): File {
    val file = File(FILE_OUTPUT)

    file.bufferedWriter()
        .use { writer ->
            table.entries
                .forEach { entry ->
                    writer.write(formatLine(entry.key, entry.value))
                    writer.newLine()
                }
        }

    return file
}

private fun formatLine(code: String, word: String) = "$code - $word"