package <%= appPackage %>.data.source

import <%= appPackage %>.data.repository.BufferooCache
import <%= appPackage %>.data.repository.BufferooDataStore
import javax.inject.Inject

/**
 * Create an instance of a BufferooDataStore
 */
class BufferooDataStoreFactory @Inject constructor(
        private val bufferooCache: BufferooCache,
        private val bufferooCacheDataStore: BufferooCacheDataStore,
        private val bufferooRemoteDataStore: BufferooRemoteDataStore) {

    /**
     * Returns a DataStore based on whether or not there is content in the cache and the cache
     * has not expired
     */
    fun retrieveDataStore(): BufferooDataStore {
        if (bufferooCache.isCached() && !bufferooCache.isExpired()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }

    /**
     * Return an instance of the Remote Data Store
     */
    fun retrieveCacheDataStore(): BufferooDataStore {
        return bufferooCacheDataStore
    }

    /**
     * Return an instance of the Cache Data Store
     */
    fun retrieveRemoteDataStore(): BufferooDataStore {
        return bufferooRemoteDataStore
    }

}