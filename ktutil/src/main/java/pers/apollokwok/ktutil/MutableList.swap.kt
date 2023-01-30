package pers.apollokwok.ktutil

public fun <E> MutableList<E>.swap(i: Int, j: Int){
    this[i] = this[j].also { this[j] = this[i] }
}