package pers.apollokwok.ktutil

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * A delegate interface integrating the [checkProperty] and [getValue].
 */
public interface KReadOnlyProperty<in T, out V> {
    public fun checkProperty(thisRef: T, property: KProperty<*>) {}

    public fun getValue(thisRef: T, property: KProperty<*>): V

    public operator fun provideDelegate(
        thisRef: T,
        property: KProperty<*>,
    ): ReadOnlyProperty<T, V> {
        checkProperty(thisRef, property)

        return ReadOnlyProperty{ _, _ -> getValue(thisRef, property) }
    }
}

/**
 * A delegate interface integrating the [checkProperty], [getValue], and [setValue].
 */
public interface KReadWriteProperty<in T, V> : KReadOnlyProperty<T, V> {
    public fun setValue(thisRef: T, property: KProperty<*>, value: V)

    public override operator fun provideDelegate(
        thisRef: T,
        property: KProperty<*>,
    ): ReadWriteProperty<T, V> {
        checkProperty(thisRef, property)

        return object : ReadWriteProperty<T, V> {
            override fun getValue(thisRef: T, property: KProperty<*>): V =
                this@KReadWriteProperty.getValue(thisRef, property)

            override fun setValue(thisRef: T, property: KProperty<*>, value: V) {
                this@KReadWriteProperty.setValue(thisRef, property, value)
            }
        }
    }
}