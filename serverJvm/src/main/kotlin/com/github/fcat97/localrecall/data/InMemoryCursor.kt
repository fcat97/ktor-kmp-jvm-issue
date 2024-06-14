package com.github.fcat97.localrecall.data

class InMemoryCursor: Cursor {
    private var searchPaths = mutableSetOf<SearchPath>()

    override suspend fun getIndex(term: String): Index? {
        TODO("Not yet implemented")
    }

    override suspend fun updateIndex(index: Index) {
        TODO("Not yet implemented")
    }

    override suspend fun getSearchPaths(): List<SearchPath> {
        return searchPaths.toList()
    }

    override suspend fun addSearchPath(path: String) {
        searchPaths.add(InMemSearchPath(path))
    }

    override suspend fun removeSearchPath(path: String) {
        searchPaths.removeAll {
            it.getPath() == path
        }
    }

    override suspend fun getPreference(): Preference {
        TODO("Not yet implemented")
    }

    override suspend fun updatePreference(preference: Preference) {
        TODO("Not yet implemented")
    }
}

// in-memory schema -----------------------------------------------------
data class InMemSearchPath(val _path: String): SearchPath {
    override fun getPath(): String {
        return _path
    }
}