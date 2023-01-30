package pers.apollokwok.ktutil

/**
 * Makes all [elements] of the nearest shared type [T] [act].
 */
public inline fun <T> allDo(vararg elements: T, act: (T)->Unit){
    elements.forEach(act)
}