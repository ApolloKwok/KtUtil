package pers.apollokwok.ktutil

/**
 * Returns the string of [this] with [n] decimals.
 */
public fun Double.roundToString(n: Int = 0): String {
    require(n >= 0){
        "The argument 'n' can't be negative!"
    }
    return String.format("%.${n}f", this)
}

/**
 * Returns the string of [this] with [n] decimals.
 */
public fun Float.roundToString(n: Int = 0): String {
    require(n >= 0){
        "The argument 'n' can't be negative!"
    }
    return String.format("%.${n}f", this)
}