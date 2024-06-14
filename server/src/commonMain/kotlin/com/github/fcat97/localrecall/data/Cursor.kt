package com.github.fcat97.localrecall.data

interface Cursor {
    suspend fun getIndex(term: String): Index?
    suspend fun updateIndex(index: Index)

    suspend fun getSearchPaths(): List<SearchPath>
    suspend fun addSearchPath(path: String)
    suspend fun removeSearchPath(path: String)

    suspend fun getPreference(): Preference
    suspend fun updatePreference(preference: Preference)
}