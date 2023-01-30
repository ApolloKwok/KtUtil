package pers.apollokwok.ktutil

import java.io.Serializable

/**
 * Similar to Pair and Triple.
 */
public data class Quintuple<A, B, C, D, E>(
    public val first: A,
    public val second: B,
    public val third: C,
    public val fourth: D,
    public val fifth: E,
) : Serializable {

    /**
     * Returns string representation of the [Quintuple] including its [first], [second], [third]
     * [fourth] and [fifth] values.
     */
    public override fun toString(): String = "($first, $second, $third, $fourth, $fifth)"
}