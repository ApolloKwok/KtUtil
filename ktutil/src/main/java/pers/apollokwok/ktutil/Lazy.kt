package pers.apollokwok.ktutil

import java.io.Serializable
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Call [lazy] with [LazyThreadSafetyMode.NONE].
 */
public fun <T> lazyFast(initialize: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initialize)

@Suppress("ClassName")
private object UNINITIALIZED_VALUE

// todo: enable the other two modes
/**
 * Call [lazy] with [LazyThreadSafetyMode.NONE] and a receiver of type [T].
 */
public fun <T, V> receivedLazy(initializer: T.() -> V): ReadOnlyProperty<T, V> =
    object : ReadOnlyProperty<T, V>, Serializable {
        private var value: Any? = UNINITIALIZED_VALUE

        override fun getValue(thisRef: T, property: KProperty<*>): V {
            if (value === UNINITIALIZED_VALUE)
                value = thisRef.initializer()
            @Suppress("UNCHECKED_CAST")
            return value as V
        }

        override fun toString(): String =
            if (value !== UNINITIALIZED_VALUE)
                value.toString()
            else
                "Lazy value not initialized yet."

        private fun writeReplace(): Any = InitializedLazyImpl(value)
    }

private class InitializedLazyImpl<out T>(override val value: T) : Lazy<T>, Serializable {
    override fun isInitialized(): Boolean = true
    override fun toString(): String = value.toString()
}