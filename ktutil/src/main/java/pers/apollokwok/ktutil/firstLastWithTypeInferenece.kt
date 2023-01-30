package pers.apollokwok.ktutil

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull

//region Iterable
/**
 * Returns the first element of specified type [V].
 */
public inline fun <T, reified V: T> Iterable<T>.first(): V = first { it is V } as V

/**
 * Returns the first element of specified type [V], or `null` if that element was not found.
 */
public inline fun <T, reified V: T> Iterable<T>.firstOrNull(): V? = firstOrNull { it is V } as V?

/**
 * Returns the last element of specified type [V].
 */
public inline fun <T, reified V: T> Iterable<T>.last(): V = first { it is V } as V

/**
 * Returns the last element of specified type [V], or `null` if that element was not found.
 */
public inline fun <T, reified V: T> Iterable<T>.lastOrNull(): V? = firstOrNull { it is V } as V?
//endregion

//region Sequence
/**
 * Returns the first element of specified type [V].
 */
public inline fun <T, reified V: T> Sequence<T>.first(): V = first { it is V } as V

/**
 * Returns the first element of specified type [V], or `null` if that element was not found.
 */
public inline fun <T, reified V: T> Sequence<T>.firstOrNull(): V? = firstOrNull { it is V } as V?

/**
 * Returns the last element of specified type [V].
 */
public inline fun <T, reified V: T> Sequence<T>.last(): V = first { it is V } as V

/**
 * Returns the last element of specified type [V], or `null` if that element was not found.
 */
public inline fun <T, reified V: T> Sequence<T>.lastOrNull(): V? = firstOrNull { it is V } as V?
//endregion

//region Flow
/**
 * Returns the first element of specified type [V].
 */
public suspend inline fun <T, reified V: T> Flow<T>.first(): V = first { it is V } as V

/**
 * Returns the first element of specified type [V], or `null` if that element was not found.
 */
public suspend inline fun <T, reified V: T> Flow<T>.firstOrNull(): V? = firstOrNull { it is V } as V?

/**
 * Returns the last element of specified type [V].
 */
public suspend inline fun <T, reified V: T> Flow<T>.last(): V = first { it is V } as V

/**
 * Returns the last element of specified type [V], or `null` if that element was not found.
 */
public suspend inline fun <T, reified V: T> Flow<T>.lastOrNull(): V? = firstOrNull { it is V } as V?
//endregion