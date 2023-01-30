package pers.apollokwok.ktutil

import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Returns the [update]d value if [this] matches [predicate], or [this] if not.
 */
public inline fun <T> T.updateIf(
    predicate: (T) -> Boolean,
    update: (T) -> T,
): T{
    contract {
        callsInPlace(predicate, InvocationKind.EXACTLY_ONCE)
    }
    if (predicate(this))
        return update(this)
    else
        return this
}