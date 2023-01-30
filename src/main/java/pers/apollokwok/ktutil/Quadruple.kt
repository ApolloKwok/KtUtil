package pers.apollokwok.ktutil

import java.io.Serializable

/**
 * Similar to Pair and Triple.
 */
public data class Quadruple<A, B, C, D>(
    public val first: A,
    public val second: B,
    public val third: C,
    public val fourth: D,
) : Serializable {

    /**
     * Returns string representation of the [Quadruple] including its [first], [second], [third] and [fourth] values.
     */
    public override fun toString(): String = "($first, $second, $third, $fourth)"
}