package pers.apollokwok.ktutil

public fun String.lowercaseFirst(): String = replaceFirstChar { it.lowercase() }
public fun String.uppercaseFirst(): String = replaceFirstChar { it.uppercase() }