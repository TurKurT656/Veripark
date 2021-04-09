package com.turkurt656.buildsrc.modules

fun module(vararg path: String): String {
    var completePath = ""
    for (p in path) completePath += ":$p"
    return completePath
}