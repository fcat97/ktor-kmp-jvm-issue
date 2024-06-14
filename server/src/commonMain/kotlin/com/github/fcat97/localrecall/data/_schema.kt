package com.github.fcat97.localrecall.data

interface Index {
    fun getTerm(): String
    fun getPaths(): List<FilePath>
}

interface FilePath {
    fun getPath(): String
    fun getWeight(): Int
}

interface SearchPath {
    fun getPath(): String
}

interface SearchEngine {
    fun getName(): String
    fun getUrl(): String
    fun getIconUrl(): String
}

interface Preference {
    fun getSelectedSearchEngine(): String
}