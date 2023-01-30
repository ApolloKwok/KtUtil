package pers.apollokwok.ktutil

private fun Number.parseToOrder(): String{
    val str = toString()
    val suffix = when(str.last()){
        '1' -> "st"
        '2' -> "nd"
        '3' -> "rd"
        else -> "th"
    }
    return "$str$suffix"
}

/**
 * Returns a string with a right postfix after [this].
 */
public fun Short.toOrder(): String = parseToOrder()

/**
 * Returns a string with a right postfix after [this].
 */
public fun Int.toOrder(): String = parseToOrder()

/**
 * Returns a string with a right postfix after [this].
 */
public fun Long.toOrder(): String = parseToOrder()