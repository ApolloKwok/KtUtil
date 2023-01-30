package pers.apollokwok.ktutil.flow

import kotlinx.coroutines.flow.*

/**
 * Returns a flow in which each element is not `null`.
 */
@Suppress("UNCHECKED_CAST")
public fun <T> Flow<T?>.filterNotNull(): Flow<T> =
    filterNot { it == null } as Flow<T>