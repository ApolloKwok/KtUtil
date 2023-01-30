package pers.apollokwok.ktutil

/**
 * Is used somewhere little riskily reachable and unexpected, and you don't want to explain.
 */
@Suppress("FunctionName")
public fun Bug(): Nothing = error("Bug!")

/**
 * Returns [Nothing] only for type inferences, which is used somewhere certainly unreachable.
 */
@Suppress("FunctionName")
public fun Unreachable(): Nothing = error("Unreachable!")