package pers.apollokwok.ktutil

/**
 * A simplified writing style of repeating [act] for [this] times, like
 * ```
 * 3 * { println(1) }
 */
public inline operator fun Int.times(act: (Int) -> Unit) {
    (0 until this).forEach(act)
}

/**
 * Returns a string of [this] repeated for [i] times.
 */
public operator fun CharSequence.times(i: Int): String = repeat(i)

/**
 * @see CharSequence.times
 */
public operator fun Int.times(c: CharSequence): String = c * this

/**
 * @see CharSequence.times
 */
public operator fun Char.times(i: Int): String = toString() * i

/**
 * @see CharSequence.times
 */
public operator fun Int.times(c: Char): String = c * this