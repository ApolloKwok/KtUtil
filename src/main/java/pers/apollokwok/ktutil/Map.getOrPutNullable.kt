package pers.apollokwok.ktutil

/**
 * Since `MutableMap.getOrPut` always invokes [getValue] if the got value is `null`, what if [V] is nullable?
 * This can be solved by this function.
 */
@Suppress("UNCHECKED_CAST")
public inline fun <T, V> MutableMap<T, V>.getOrPutNullable(key: T, getValue: (T)->V): V =
    if (containsKey(key))
        get(key) as V
    else
        getValue(key).also{ put(key, it) }