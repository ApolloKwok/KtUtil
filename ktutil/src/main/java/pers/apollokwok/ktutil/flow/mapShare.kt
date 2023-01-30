package pers.apollokwok.ktutil.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*

/**
 * Maps [this] via [transform] and shares it in [scope].
 */
public inline fun <X, Y> Flow<X>.mapShare(
    scope: CoroutineScope,
    replay: Int = 0,
    started: SharingStarted = SharingStarted.Eagerly,
    crossinline transform: suspend (X) -> Y,
): SharedFlow<Y> =
    map(transform).shareIn(scope, started, replay)